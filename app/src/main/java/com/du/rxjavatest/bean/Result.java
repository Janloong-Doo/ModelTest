package com.du.rxjavatest.bean;

import java.util.List;
import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class Result{

	@SerializedName("stat")
	public abstract String stat();

	@SerializedName("data")
	public abstract List<DataItem> data();

	public static TypeAdapter<Result> typeAdapter(Gson gson) {
		return new AutoValue_Result.GsonTypeAdapter(gson);
	}
}