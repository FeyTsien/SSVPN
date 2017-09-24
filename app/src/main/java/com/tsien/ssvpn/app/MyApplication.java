package com.tsien.ssvpn.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.util.Log;

/**
 * @author :   FeyTsien
 * @date :   2017/8/15
 */

public class MyApplication extends Application {

    private static Context mContext = null;

    private static Handler handler;
    private static int mainThreadId;

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        System.out.println("获取context：etApplicationContext()");
        mContext = getApplicationContext();
        handler = new Handler();//创建Handle
        mainThreadId = Process.myTid();//得到主线程id
        AppData.saveAndroidId();
    }

    //清除登陆
    public static void clearLogin() {
        Log.i("clearLogin", "isTokenExpired: +++++++++++++++++++++++++++++++0005");
        AppData.saveUid("");
        AppData.saveUserName("");
        AppData.setIsLoginEd(false);
    }

    /**
     * 解决java.lang.NoClassDefFoundError错误，方法数超过65536了
     * 5.0以下系统会出次问题
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
