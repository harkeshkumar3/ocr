package com.abbyy.formatter;

public class InformationFormat {
	
	private String id;
	private String Name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "InfomationFormat [id=" + id + ", Name=" + Name + "]";
	}
	
	

}
