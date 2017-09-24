package com.tsien.ssvpn.manager;

import com.tsien.ssvpn.interfaces.ProjectAPI;
import com.tsien.ssvpn.utils.RetrofitUtil;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * w网络请求的工具类
 */

public class HttpManager {

    private String TAG = "HttpManager";

    public static HttpManager httpManager = new HttpManager();

    private HttpManager() {

    }


    public static HttpManager getHttpManager() {
        return httpManager;
    }


    /**
     * get方式请求
     * 封装时，传递observer
     *
     * @param url
     * @param observer
     */
    public void getMethod(String url, Observer<String> observer) {
        //获取被观察者
        Observable<String> observable = RetrofitUtil.getInstance().get2(ProjectAPI.class).getMethod(url);
        //在子线程中执行请求，在主线程观察，将信息设置给观察者
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }

    /**
     * Post方式请求
     * 封装时，传递observer
     *
     * @param url
     * @param observer
     */
    public void postMethod(String url, Observer<String> observer, Map map) {

//        Observable<String> observable = RetrofitUtil.getInstance().get(ProjectAPI.class).postMethod(deviceId, uid, sign, url, map);
        //在子线程中执行请求，在主线程观察，将信息设置给观察者
//        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(observer);

    }

}
