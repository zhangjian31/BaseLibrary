package com.jery.lib.networklibrary.utils;

import android.content.Context;
import android.widget.Toast;


public class UIToast {
    private static UIToast instance;

    private Context context;
    private Toast mToast;

    private UIToast() {
    }

    public static UIToast getInstance() {
        if (instance == null) {
            synchronized (UIToast.class) {
                if (instance == null)
                    instance = new UIToast();
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
