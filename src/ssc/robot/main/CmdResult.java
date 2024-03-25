package ssc.robot.main;

public class CmdResult {
	private boolean isValid;
	private CmdType cmdType;
	
	public CmdResult() {
		isValid = true;
		cmdType = CmdType.NONE;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void isValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public CmdType getCmdType() {
		return cmdType;
	}
	
	public void setCmdType(CmdType cmdType) {
		this.cmdType = cmdType;
	}
}
