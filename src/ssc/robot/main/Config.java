package ssc.robot.main;

public class Config {
	private boolean isCaseSencitive;
	private boolean isRequireInfoLog;
	private boolean isRequireWarnLog;
	private boolean isRequireErrorLog;
	
	public Config() {
		isCaseSencitive = true;
		isRequireInfoLog = false;
		isRequireWarnLog = true;
		isRequireErrorLog = true;
	}
	
	public boolean isCaseSencitive() {
		return isCaseSencitive;
	}
	public void setCaseSencitive(boolean isCaseSencitive) {
		this.isCaseSencitive = isCaseSencitive;
	}
	
	public boolean isRequireInfoLog() {
		return isRequireInfoLog;
	}
	public void setRequireInfoLog(boolean isRequireInfoLog) {
		this.isRequireInfoLog = isRequireInfoLog;
	}
	
	public boolean isRequireWarnLog() {
		return isRequireWarnLog;
	}
	public void setRequireWarnLog(boolean isRequireWarnLog) {
		this.isRequireWarnLog = isRequireWarnLog;
	}
	public boolean isRequireErrorLog() {
		return isRequireErrorLog;
	}
	public void setRequireErrorLog(boolean isRequireErrorLog) {
		this.isRequireErrorLog = isRequireErrorLog;
	}
	
}
