package com.jery.lib.networklibrary.service;


import com.jery.lib.networklibrary.callback.RequestCallBack;
import com.jery.lib.networklibrary.exception.AuthenException;
import com.jery.lib.networklibrary.exception.ResultException;
import com.jery.lib.networklibrary.model.BaseResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ServiceExecutor {


    private ServiceExecutor() {
    }

    private static ServiceExecutor instance;

    public static ServiceExecutor getInstance() {
        if (instance == null) {
            synchronized (ServiceExecutor.class) {
                if (instance == null)
                    instance = new ServiceExecutor();
            }
        }
        return instance;
    }

    /**
     * 异步请求数据
     *
     * @param observable
     * @param observer
     */
    public void execute(Observable<? extends BaseResult> observable, RequestCallBack observer) {
        // 如果subscriber == null，则实例化一个不发送结果的Callback
        if (observer == null)
            observer = new RequestCallBack("null", false);

        observable
                .observeOn(Schedulers.io())
                .map(new Function<BaseResult, BaseResult>() {
                    @Override
                    public BaseResult apply(BaseResult baseResult) throws Exception {//拿到结果，先分析返回码，特殊返回码特殊处理，如401 token过期则发送token过期错误事件

                        //统一处理错误码
                        handleBaseResult(baseResult);

                        return baseResult;
                    }
                }).observeOn(Schedulers.io())
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                        return throwableObservable.zipWith(Observable.range(1, 3), new BiFunction<Throwable, Integer, Throwable>() {
                            @Override
                            public Throwable apply(Throwable throwable, Integer integer) throws Exception {
                                if (integer < 3) //接口重试3次，第三次抛出结果请求错误
                                    return throwable;
                                else
                                    return new ResultException(throwable.getMessage());
                            }
                        }).flatMap(new Function<Throwable, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                                if (throwable instanceof AuthenException) {
                                    // Request token refresh
//                                    BaseResult result = OauthServiceImpl.getInstance().getAccessTokenSync();
//                                    if (result.getRetCode() == BaseResult.RESULT_SUCCESS) { //获取到token
//
//                                        return Observable.timer(3, TimeUnit.SECONDS);
//
//                                    } else if (result.getRetCode() == BaseResult.RESULT_RISK_ERROR) { //设备被加入到黑名单
//
//                                        return Observable.error(new RiskControlException(result.getRetMsg()));
//
//                                    } else { //token获取异常
//
//                                        return Observable.error(throwable);
//                                    }
                                }
                                return Observable.error(throwable);
                            }
                        });
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(observer);


    }

    private void handleBaseResult(BaseResult baseResult) {

    }


}
