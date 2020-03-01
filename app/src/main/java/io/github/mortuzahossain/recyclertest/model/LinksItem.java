package io.github.mortuzahossain.recyclertest.model;

import com.google.gson.annotations.SerializedName;

public class LinksItem{

	@SerializedName("link")
	private String link;

	@SerializedName("title")
	private String title;

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"LinksItem{" + 
			"link = '" + link + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}