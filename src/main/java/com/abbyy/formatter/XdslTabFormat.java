package com.abbyy.formatter;

public class XdslTabFormat {
	
	private LineActionFormat lineAction;
	private ProfileFormat profile;
	private InformationFormat information;
	
	
	public LineActionFormat getLineAction() {
		return lineAction;
	}
	public void setLineAction(LineActionFormat lineAction) {
		this.lineAction = lineAction;
	}
	public ProfileFormat getProfile() {
		return profile;
	}
	public void setProfile(ProfileFormat profile) {
		this.profile = profile;
	}
	public InformationFormat getInformation() {
		return information;
	}
	public void setInformation(InformationFormat information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "XdslTabFormat [lineAction=" + lineAction + ", profile=" + profile + ", information=" + information
				+ "]";
	}
	
	
	

}
