package com.enviroment.unomerintegration;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;

import com.umeng.commonsdk.UMConfigure;

import java.util.List;

public class SubApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UMConfigure.init(this, "5abcb585f43e486d3000001b", "UnomerTesting", 1, null);
        UMConfigure.setLogEnabled(true);

        initUnomer(getApplicationContext());
    }


//    public boolean isMainProcess() {
//        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
//        if (am == null) return false;
//        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
//        if (processInfos == null) {
//            return false;
//        }
//        String mainProcessName = getPackageName();
//        int myPid = Process.myPid();
//        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
//            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void initUnomer(Context activity){
        UnomerSurvey.getInstace().initUnomer(activity);
    }
}