package com.publisherdata.model;

import java.util.ArrayList;
import java.util.List;

public class DashboardTemplate {

	   public List<TemplateMap> getTempmap() {
		return tempmap;
	}
	public void setTempmap(List<TemplateMap> tempmap) {
		this.tempmap = tempmap;
	}
	public List<TimeSpanMap> getTimespanmap() {
		return timespanmap;
	}
	public void setTimespanmap(List<TimeSpanMap> timespanmap) {
		this.timespanmap = timespanmap;
	}
	public List<DropdownMap> getDropdownmap() {
		return dropdownmap;
	}
	public void setDropdownmap(List<DropdownMap> dropdownmap) {
		this.dropdownmap = dropdownmap;
	}
	List<TemplateMap> tempmap = new ArrayList<TemplateMap>();
	    List<TimeSpanMap> timespanmap = new ArrayList<TimeSpanMap>();
	    List<DropdownMap> dropdownmap = new ArrayList<DropdownMap>();
	    
	
	
}
