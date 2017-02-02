package com.du.rxjavatest.utils;

import com.du.rxjavatest.bean.DataItem;
import com.du.rxjavatest.bean.Recivefornews;
import com.du.rxjavatest.bean.Responsefornews;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

import static android.R.attr.type;

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
}
