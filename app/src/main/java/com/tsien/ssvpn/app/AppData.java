package com.tsien.ssvpn.app;

import com.blankj.utilcode.util.SPUtils;
import com.tsien.ssvpn.utils.CommonUtils;
import com.tsien.ssvpn.utils.SharedPreferencesUtils;

/**
 * Created by Administrator on 2017/8/31.
 */

public class AppData {

    private static final String IS_NEW_APP = "isNewApp";
    private static final String IS_LOGIN_ED = "isLoginEd";


    /**
     * 引导页专用
     * @param firstOpen
     */
    public static void savaFirstOpen(int firstOpen) {
        SPUtils.getInstance().put("FirstOpen", firstOpen);
    }

    /**
     * 查看是否是第一次进入主界面（是否显示引导页）
     */
    public static int getFirstOpen(){
        return SPUtils.getInstance().getInt("FirstOpen", 1);
    }


    /**
     * 设置是否是最新版APP
     *
     * @param isNewApp
     */
    public static void setIsNewApp(boolean isNewApp) {
        SPUtils.getInstance().put(IS_NEW_APP, isNewApp);
    }

    /**
     * 查询是否是最新版APP
     *
     * @return
     */
    public static boolean isNewApp() {
        return SPUtils.getInstance().getBoolean(IS_NEW_APP, false);
    }


    /**
     * 设置是否登陆
     *
     * @param isLoginEd
     */
    public static void setIsLoginEd(boolean isLoginEd) {
        SPUtils.getInstance().put(IS_LOGIN_ED, isLoginEd);
    }

    /**
     * 查询是否登陆
     *
     * @return
     */
    public static boolean isLoginEd() {
        return SPUtils.getInstance().getBoolean(IS_LOGIN_ED, false);
    }


    /**
     * 保存UserId
     */
    public static void saveUid(String username) {
        SPUtils.getInstance().put("UID", username);
    }

    /**
     * 获取UserId
     */
    public static String getUid() {
        return SPUtils.getInstance().getString("UID", null);
    }

    /**
     * 保存UserName
     */
    public static void saveUserName(String username) {
        SPUtils.getInstance().put("USERNAME", username);
    }
    /**
     * 获取UserName
     */
    public static String getUserName() {
        return SPUtils.getInstance().getString("USERNAME", null);
    }

    /**
     * 保存手机设备ID
     */
    public static void saveAndroidId() {
        SPUtils.getInstance().put("ANDROID_ID", CommonUtils.getIMEI(MyApplication.getContext()));
    }

    /**
     * 获取手机设备ID
     */
    public static String getAndroidId() {
        return SPUtils.getInstance().getString("ANDROID_ID", null);
    }
}
