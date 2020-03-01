package io.github.mortuzahossain.recyclertest.model;

import com.google.gson.annotations.SerializedName;

public class TodayResponse{
//	http://history.muffinlabs.com/date
	@SerializedName("date")
	private String date;

	@SerializedName("data")
	private Data data;

	@SerializedName("url")
	private String url;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"TodayResponse{" + 
			"date = '" + date + '\'' + 
			",data = '" + data + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}