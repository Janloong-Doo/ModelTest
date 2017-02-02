package com.du.rxjavatest.utils;

import com.du.rxjavatest.bean.DataItem;
import com.du.rxjavatest.bean.Responsefornews;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okrx.RxAdapter;

import okhttp3.Call;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/2/2.
 */

public class OkGoUtils {

    public static void get() {
        String url = "http://v.juhe.cn/toutiao/index";
        HttpParams params = new HttpParams("key", "81318650aa7dfb468fb9275eef213c8e");
        HttpParams leixing = new HttpParams("type", "top");
        OkGo.get(url)
                .tag("news")
                .cacheKey("newscachekey")
                .cacheMode(CacheMode.DEFAULT)
                .params(params)
                .params(leixing)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        System.out.println("%%%%%%%%%%%%%");
                        System.out.println(s);
                        System.out.println("%%%%%%%%%%%%%");
                        Gson gson = new GsonBuilder().registerTypeAdapterFactory
                                (MyAdapterFactory.create()).create();

//                        Recivefornews recivefornews = gson.fromJson(s, Recivefornews.class);
//
//                        System.out.println("----------");
//                        System.out.println(recivefornews);
//                        System.out.println(recivefornews.newsresult().newslist().get(0)
// .biaoti());
//                        System.out.println("----------");

                        Responsefornews responsefornews = gson.fromJson(s, Responsefornews.class);
                        DataItem dataItem = responsefornews.result().data().get(2);
                        System.out.println(dataItem.authorName());
                        System.out.println(dataItem.date());
                        System.out.println(dataItem.title());
                    }
                });
    }

    public static void getbyRx() {
        String url = "http://v.juhe.cn/toutiao/index";
//        Observable<String> call
        OkGo.get(url)
                .params("key", "81318650aa7dfb468fb9275eef213c8e")
                .params("type", "junshi")
                .getCall(StringConvert.create(), RxAdapter.<String>create())
//                call.doOn...
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        System.out.println("我要开始请求了");
                    }
                })
                .observeOn(Schedulers.io())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("-----------");
                        System.out.println(s);
                        System.out.println("-----------");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("请求失败");
                    }
                });
    }
}
