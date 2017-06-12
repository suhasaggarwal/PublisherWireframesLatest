package com.publisherdata.model;

import java.util.ArrayList;
import java.util.List;

public class DashboardTemplate {

	 
	
	
	List<TemplateMap> cardtitletemplate = new ArrayList<TemplateMap>();
	
	public List<TemplateMap> getCardtitletemplate() {
		return cardtitletemplate;
	}
	public void setCardtitletemplate(List<TemplateMap> cardtitletemplate) {
		this.cardtitletemplate = cardtitletemplate;
	}
	public TimeSpanMap getTimespantemplate() {
		return timespantemplate;
	}
	public void setTimespantemplate(TimeSpanMap timespantemplate) {
		this.timespantemplate = timespantemplate;
	}
	public DropdownMap getDropdowntemplate() {
		return dropdowntemplate;
	}
	public void setDropdowntemplate(DropdownMap dropdowntemplate) {
		this.dropdowntemplate = dropdowntemplate;
	}
	TimeSpanMap timespantemplate = new TimeSpanMap();
	DropdownMap dropdowntemplate = new DropdownMap();
	    
	
	
}
