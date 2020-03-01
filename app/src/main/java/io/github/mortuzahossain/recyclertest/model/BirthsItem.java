package io.github.mortuzahossain.recyclertest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BirthsItem{

	@SerializedName("no_year_html")
	private String noYearHtml;

	@SerializedName("year")
	private String year;

	@SerializedName("html")
	private String html;

	@SerializedName("links")
	private List<LinksItem> links;

	@SerializedName("text")
	private String text;

	public void setNoYearHtml(String noYearHtml){
		this.noYearHtml = noYearHtml;
	}

	public String getNoYearHtml(){
		return noYearHtml;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setHtml(String html){
		this.html = html;
	}

	public String getHtml(){
		return html;
	}

	public void setLinks(List<LinksItem> links){
		this.links = links;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"BirthsItem{" + 
			"no_year_html = '" + noYearHtml + '\'' + 
			",year = '" + year + '\'' + 
			",html = '" + html + '\'' + 
			",links = '" + links + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}