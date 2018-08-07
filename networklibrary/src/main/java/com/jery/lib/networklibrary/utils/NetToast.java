package com.jery.lib.networklibrary.utils;

import android.content.Context;
import android.widget.Toast;


public class NetToast {
    private static NetToast instance;

    private Context context;
    private Toast mToast;

    private NetToast() {
    }

    public static NetToast getInstance() {
        if (instance == null) {
            synchronized (NetToast.class) {
                if (instance == null)
                    instance = new NetToast();
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.context = context;
    }

    public void showToast(int sourceID) {
        if (context != null) {
            if (mToast != null)
                mToast.cancel();

            mToast = Toast.makeText(context, sourceID, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }

    public void showToast(String text) {
        if (context != null) {
            if (mToast != null)
                mToast.cancel();

            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            mToast.show();
        }
    }
}
