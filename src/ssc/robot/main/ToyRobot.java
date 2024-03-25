package ssc.robot.main;

import java.util.Scanner;

public class ToyRobot {
	public static void main(String[] args) {
		Config config = new Config();
		
		for(int i=0; i<args.length; i++) {
			if(args[i].equals("--case-sensitive=false")) {
				config.setCaseSencitive(false);
			}

			if(args[i].equals("--info=true")) {
				config.setRequireInfoLog(true);
			}

			if(args[i].equals("--warn=false")) {
				config.setRequireWarnLog(false);
			}

			if(args[i].equals("--error=false")) {
				config.setRequireErrorLog(false);
			}
		}
		
		Log log = new Log(config);
		log.info("Invoke ToyRobot.main");
		
		System.out.println("Please enter command: ");
		Robot robot = new Robot(config);
		CmdResult result = new CmdResult();
		try (Scanner cmdScanner = new Scanner(System.in)) {
			while(!result.getCmdType().equals(CmdType.REPORT)) {
				String cmd = cmdScanner.nextLine();
				robot.exec(cmd, result);
				log.info("Robot status: "+robot.getStatus());
				
				if(!result.isValid()) {
					log.error(result.getCmdType()+" command is invalid");
				}
				
				if(result.isValid() && result.getCmdType().equals(CmdType.REPORT)) {
					System.out.println("Output: "+robot.getReport());
				}
			}
		}
	}
}
