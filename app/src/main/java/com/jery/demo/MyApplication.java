package com.jery.demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.jery.config.JeryConfig;
import com.jery.lib.networklibrary.utils.UIToast;

import java.util.List;

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        new JeryConfig.JeryConfigBuilder().baseUrl("http://www.jeryzhang.cn").create();
        boolean mainProcess = mainProcess();
        if (mainProcess) {
            UIToast.getInstance().init(this);
        }
    }

    protected boolean mainProcess() {
        String curProcessName = getProcessName(this, android.os.Process.myPid());
        if (!TextUtils.isEmpty(curProcessName)) {
            return curProcessName.equals(getPackageName());
        }
        return false;
    }

    protected String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
            if (runningApps == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName;
                }
            }
        }
        return "";
    }
}
