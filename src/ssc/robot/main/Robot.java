package ssc.robot.main;

public class Robot {
	private int x;
	private int y;
	private Direction f;
	private boolean isReady;
	private Config config;
	private Log log;
	
	public Robot(Config config) {
		this.config = config;
		isReady = false;
		log = new Log(config);
	}
	
	public void exec(String cmd, CmdResult result) {
		log.info("Invoke Robot.cmd");
		
		log.info("Robot Status: "+getStatus());
		
		if(!config.isCaseSencitive()) {
			cmd = cmd.toUpperCase();
		}

		//Check if this is the first loop
		String[] cmdElement = cmd.split(" ");
		log.info("cmdElement.length: "+cmdElement.length);
		
		//Check if the robot has been placed
		if(isReady) {
			//The robot has been placed
			if(cmdElement.length == 2 && cmdElement[0].equals("PLACE") && place(cmdElement)) {
				//Replace the robot command success
				result.isValid(true);
				result.setCmdType(CmdType.PLACE);
				return;
			}
			if(cmdElement.length == 1) {
				//One word command
				switch(cmdElement[0]) {
					case "MOVE":
						result.isValid(move());
						result.setCmdType(CmdType.MOVE);
						break;
					case "LEFT":
						result.isValid(left());
						result.setCmdType(CmdType.LEFT);
						break;
					case "RIGHT":
						result.isValid(right());
						result.setCmdType(CmdType.RIGHT);
						break;
					case "REPORT":
						result.isValid(report());
						result.setCmdType(CmdType.REPORT);
						break;
					default:
						result.isValid(false);
						result.setCmdType(CmdType.NONE);
				}
				result.isValid(true);
				return;
			}
			result.isValid(false);
		}
		else {
			//The robot has not been placed yet
			if(cmdElement.length == 2 && cmdElement[0].equals("PLACE") && place(cmdElement)) {
				//Place the robot command success
				isReady = true;
				result.isValid(true);
				result.setCmdType(CmdType.PLACE);
			}
			else {
				log.error("PLACE command requires arguments X,Y,F");
				result.isValid(false);
				result.setCmdType(CmdType.PLACE);				
			}
		}
	}
	
	private boolean place(String[] cmdElement) {
		log.info("Invoke Robot.place");
		
		String params = "";
		for(int i=1; i<cmdElement.length; i++) {
			System.out.println("cmdElement[i]: "+cmdElement[i]);
			params += cmdElement[i];
		}
		
		String[] paramArr = params.split(",");
		if(paramArr.length!=3) {
			return false;
		}
		
		int x=0;
		int y=0;
		Direction f = null;
		
		try {
			x = Integer.parseInt(paramArr[0]);
			y = Integer.parseInt(paramArr[1]);			
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		if(x<0 || x>5 || y<0 || y>5) {
			log.warn("Unable to comply. The robot is placing the robot out side the table");
			return false;
		}
		
		switch(paramArr[2]) {
			case "NORTH":
				f = Direction.NORTH;
				break;
			case "SOUTH":
				f = Direction.SOUTH;
				break;
			case "EAST":
				f = Direction.EAST;
				break;
			case "WEST":
				f = Direction.WEST;
				break;
			default:
				return false;
		}
		
		this.x = x;
		this.y = y;
		this.f = f;			
		return true;
	}
	
	public boolean move() {
		switch(f) {
			case NORTH:
				if(y==Table.MAX_Y) {
					log.warn("Unable to comply. The robot is moving out of the table");
					return false;
				}
				y++;
				break;
			case SOUTH:
				if(y==Table.MIN_Y) {
					log.warn("Unable to comply. The robot is moving out of the table");
					return false;
				}
				y--;
				break;
			case EAST:
				if(x==Table.MAX_X) {
					log.warn("Unable to comply. The robot is moving out of the table");
					return false;
				}
				x++;
				break;
			case WEST:
				if(x==Table.MIN_X) {
					log.warn("Unable to comply. The robot is moving out of the table");
					return false;
				}
				x--;
				break;
			
		}
		return true;
	}
	
	public boolean left() {
		switch(f) {
			case NORTH:
				f = Direction.WEST;
				break;
			case SOUTH:
				f = Direction.EAST;
				break;
			case EAST:
				f = Direction.NORTH;
				break;
			case WEST:
				f = Direction.SOUTH;
				break;
			
		}
		return true;
	}
	
	public boolean right() {
		switch(f) {
			case NORTH:
				f = Direction.EAST;
				break;
			case SOUTH:
				f = Direction.WEST;
				break;
			case EAST:
				f = Direction.SOUTH;
				break;
			case WEST:
				f = Direction.NORTH;
				break;
			
		}
		return true;
	}
		
	public boolean report() {
		return true;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direction getF() {
		return f;
	}
	
	public String getReport() {
		return x+","+y+","+f;
	}
	
	public String getStatus() {
		return "X="+x+", Y="+y+", F="+f+", isReady="+isReady;
	}
}
