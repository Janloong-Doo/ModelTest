package com.du.rxjavatest.bean2;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/2.
 */
@AutoValue
public abstract class Recivefornews implements Parcelable {
    @SerializedName("error_code")
   public abstract String recivecode();

    @SerializedName("reason")
   public abstract String reasonname();

    @SerializedName("result")
    public abstract Newsresult newsresult();

    public static Recivefornews create(String recivecode, String reasonname, Newsresult
            newsresult) {
        return builder()
                .recivecode(recivecode)
                .reasonname(reasonname)
                .newsresult(newsresult)
                .build();
    }

    public static TypeAdapter<Recivefornews> typeAdapter(Gson gson) {
        return new $AutoValue_Recivefornews.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new $$AutoValue_Recivefornews.Builder();
    }

    /**
     * 请求数据实体
     */
    @AutoValue
    public abstract static class Newsresult implements Parcelable{

        @SerializedName("stat")
        public abstract String yeshuma();

        @SerializedName("data")
        public abstract ArrayList<Newsdetail> newslist();

        public static Newsresult create(String yeshuma, ArrayList<Newsdetail> newslist) {
            return builder()
                    .yeshuma(yeshuma)
                    .newslist(newslist)
                    .build();
        }

        public static TypeAdapter<Newsresult> typeAdapter(Gson gson) {
            return new $AutoValue_Recivefornews_Newsresult.GsonTypeAdapter(gson);
        }

        public static Builder builder() {
            return new $$AutoValue_Recivefornews_Newsresult.Builder();
        }

        /**
         * 请求新闻实体
         */
        @AutoValue
        public abstract static class Newsdetail implements Parcelable{
            @SerializedName("author_name")
            public abstract String author();

            @SerializedName("date")
            public abstract String shijian();

            @SerializedName("thumbnail_pic_s")
            @Nullable
            public abstract String image1();

            @SerializedName("thumbnail_pic_s02")
            @Nullable
            public abstract String image2();

            @SerializedName("thumbnail_pic_s03")
            @Nullable
            public abstract String image3();

            @SerializedName("title")
            public abstract String biaoti();

            @SerializedName("uniquekey")
            public abstract String uniquekey();

            @SerializedName("url")
            public abstract String wangzhi();

            public static Newsdetail create(String author, String shijian, String image1,
                                            String image2, String image3, String biaoti, String
                                                    uniquekey, String wangzhi) {
                return builder()
                        .author(author)
                        .shijian(shijian)
                        .image1(image1)
                        .image2(image2)
                        .image3(image3)
                        .biaoti(biaoti)
                        .uniquekey(uniquekey)
                        .wangzhi(wangzhi)
                        .build();
            }


            public static TypeAdapter<Newsdetail> typeAdapter(Gson gson) {
                return new $AutoValue_Recivefornews_Newsresult_Newsdetail.GsonTypeAdapter(gson);
            }

            public static Builder builder() {
                return new $$AutoValue_Recivefornews_Newsresult_Newsdetail.Builder();
            }

            @AutoValue.Builder
            public abstract static class Builder {
                public abstract Builder author(String author);

                public abstract Builder shijian(String shijian);

                public abstract Builder image1(String image1);

                public abstract Builder image2(String image2);

                public abstract Builder image3(String image3);

                public abstract Builder biaoti(String biaoti);

                public abstract Builder uniquekey(String uniquekey);

                public abstract Builder wangzhi(String wangzhi);

                public abstract Newsdetail build();
            }
        }

        @AutoValue.Builder
        public abstract static class Builder {
            public abstract Builder yeshuma(String yeshuma);

            public abstract Builder newslist(ArrayList<Newsdetail> newslist);

            public abstract Newsresult build();
        }
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder recivecode(String recivecode);

        public abstract Builder reasonname(String reasonname);

        public abstract Builder newsresult(Newsresult newsresult);

        public abstract Recivefornews build();
    }
}
