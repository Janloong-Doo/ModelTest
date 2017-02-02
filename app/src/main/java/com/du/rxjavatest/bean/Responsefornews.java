package com.du.rxjavatest.bean;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@Generated("com.robohorse.robopojogenerator")
@AutoValue
public abstract class Responsefornews{

	@SerializedName("result")
	public abstract Result result();

	@SerializedName("reason")
	public abstract String reason();

	@SerializedName("error_code")
	public abstract int errorCode();

	public static TypeAdapter<Responsefornews> typeAdapter(Gson gson) {
		return new AutoValue_Responsefornews.GsonTypeAdapter(gson);
	}
}