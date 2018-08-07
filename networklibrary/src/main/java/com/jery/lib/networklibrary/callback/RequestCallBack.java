package com.jery.lib.networklibrary.callback;

import com.jery.lib.networklibrary.R;
import com.jery.lib.networklibrary.exception.ResultException;
import com.jery.lib.networklibrary.model.BaseResponse;
import com.jery.lib.networklibrary.utils.UIToast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RequestCallBack implements Observer<BaseResponse> {
    private String tag;
    private boolean broadCastResult;
    protected Disposable disposable;

    public RequestCallBack(String tag) {
        this(tag, false);
    }


    public RequestCallBack(String tag, boolean broadCastResult) {
        this.tag = tag;
        this.broadCastResult = broadCastResult;
    }

    public String getTag() {
        return tag;
    }

    public boolean isBroadCastResult() {
        return broadCastResult;
    }


    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(BaseResponse baseResult) {
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ResultException) {
            UIToast.getInstance().showToast(e.getMessage());
        } else {
            UIToast.getInstance().showToast(R.string.get_fail);
        }
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void onComplete() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }


    public static class OauthErrorEvent {
    }

}
