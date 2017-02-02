package com.du.rxjavatest.bean;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class DataItem{

	@SerializedName("author_name")
	public abstract String authorName();

	@SerializedName("date")
	public abstract String date();

	@SerializedName("thumbnail_pic_s")
	@Nullable public abstract String thumbnailPicS();

	@SerializedName("uniquekey")
	@Nullable public abstract String uniquekey();

	@SerializedName("thumbnail_pic_s03")
	@Nullable public abstract String thumbnailPicS03();

	@SerializedName("thumbnail_pic_s02")
	@Nullable public abstract String thumbnailPicS02();

	@SerializedName("category")
	public abstract String category();

	@SerializedName("title")
	public abstract String title();

	@SerializedName("url")
	public abstract String url();

	public static TypeAdapter<DataItem> typeAdapter(Gson gson) {
		return new AutoValue_DataItem.GsonTypeAdapter(gson);
	}
}