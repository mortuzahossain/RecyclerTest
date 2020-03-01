package io.github.mortuzahossain.recyclertest.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("Events")
	private List<EventsItem> events;

	@SerializedName("Births")
	private List<BirthsItem> births;

	@SerializedName("Deaths")
	private List<DeathsItem> deaths;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	public void setBirths(List<BirthsItem> births){
		this.births = births;
	}

	public List<BirthsItem> getBirths(){
		return births;
	}

	public void setDeaths(List<DeathsItem> deaths){
		this.deaths = deaths;
	}

	public List<DeathsItem> getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"events = '" + events + '\'' + 
			",births = '" + births + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}