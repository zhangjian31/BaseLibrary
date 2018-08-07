package com.jery.lib.networklibrary.callback;

import com.jery.lib.networklibrary.R;
import com.jery.lib.networklibrary.exception.AuthenException;
import com.jery.lib.networklibrary.exception.ResultException;
import com.jery.lib.networklibrary.model.BaseResult;
import com.jery.lib.networklibrary.utils.NetToast;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class RequestCallBack implements Observer<BaseResult> {
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
    public void onNext(BaseResult baseResult) {
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ResultException) {
            NetToast.getInstance().showToast(e.getMessage());
        } else {
            NetToast.getInstance().showToast(R.string.get_fail);
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
