package com.abbyy.formatter;

public class ProfileFormat {
	
	private String alarmSeverity;
	private String xDslLine;
	private String customNotch;
	private String upstreamPsdMark;
	private String downstreamPsdMark;
	private String event;
	private String channel1;
	
	
	public String getAlarmSeverity() {
		return alarmSeverity;
	}
	public void setAlarmSeverity(String alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
	}
	public String getxDslLine() {
		return xDslLine;
	}
	public void setxDslLine(String xDslLine) {
		this.xDslLine = xDslLine;
	}
	public String getCustomNotch() {
		return customNotch;
	}
	public void setCustomNotch(String customNotch) {
		this.customNotch = customNotch;
	}
	public String getUpstreamPsdMark() {
		return upstreamPsdMark;
	}
	public void setUpstreamPsdMark(String upstreamPsdMark) {
		this.upstreamPsdMark = upstreamPsdMark;
	}
	public String getDownstreamPsdMark() {
		return downstreamPsdMark;
	}
	public void setDownstreamPsdMark(String downstreamPsdMark) {
		this.downstreamPsdMark = downstreamPsdMark;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getChannel1() {
		return channel1;
	}
	public void setChannel1(String channel1) {
		this.channel1 = channel1;
	}
	@Override
	public String toString() {
		return "ProfileFormat [alarmSeverity=" + alarmSeverity + ", xDslLine=" + xDslLine + ", customNotch="
				+ customNotch + ", upstreamPsdMark=" + upstreamPsdMark + ", downstreamPsdMark=" + downstreamPsdMark
				+ ", event=" + event + ", channel1=" + channel1 + "]";
	}
	
	

}
