package ssc.robot.main;

public class Log {
	private boolean isRequireInfoLog;
	private boolean isRequireWarnLog;
	private boolean isRequireErrorLog;
	
	Log(Config config) {
		isRequireInfoLog = config.isRequireInfoLog();
		isRequireWarnLog = config.isRequireWarnLog();
		isRequireErrorLog = config.isRequireErrorLog();
	}
	
	public void isRequireInfoLog(boolean isRequireInfoLog) {
		this.isRequireInfoLog = isRequireInfoLog;
	}
	
	public void isRequireWarnLog(boolean isRequireWarnLog) {
		this.isRequireWarnLog = isRequireWarnLog;
	}

	public void isRequireErrorLog(boolean isRequireErrorLog) {
		this.isRequireErrorLog = isRequireErrorLog;
	}
	
	public void info(String message) {
		if(isRequireInfoLog) {
			System.out.println(message);
		}
	}
	
	public void warn(String message) {
		if(isRequireWarnLog) {
			System.out.println("Warning: "+message);
		}
	}
	
	public void error(String message) {
		if(isRequireErrorLog) {
			System.out.println("Error: "+message);
		}
	}

}
