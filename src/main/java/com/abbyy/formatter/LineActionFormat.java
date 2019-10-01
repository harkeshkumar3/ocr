package com.abbyy.formatter;

public class LineActionFormat {
	
	private boolean startUp;
	private boolean testMode;
	private boolean delt;
	private boolean status;
	public boolean isStartUp() {
		return startUp;
	}
	public void setStartUp(boolean startUp) {
		this.startUp = startUp;
	}
	public boolean isTestMode() {
		return testMode;
	}
	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}
	public boolean isDelt() {
		return delt;
	}
	public void setDelt(boolean delt) {
		this.delt = delt;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LineActionFormat [startUp=" + startUp + ", testMode=" + testMode + ", delt=" + delt + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
	
	

}
