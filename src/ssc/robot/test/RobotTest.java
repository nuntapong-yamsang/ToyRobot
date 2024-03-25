package ssc.robot.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import ssc.robot.main.CmdResult;
import ssc.robot.main.CmdType;
import ssc.robot.main.Config;
import ssc.robot.main.Robot;

public class RobotTest {
	
	@Test
	public void testRobotExample1() {
		Config config = new Config();
		Robot robot = new Robot(config);
		CmdResult result = new CmdResult();
		
		robot.exec("PLACE 0,0,NORTH", result);
		robot.exec("MOVE", result);
		robot.exec("REPORT", result);
		
		assertEquals(result.isValid(), true);
		assertEquals(result.getCmdType(), CmdType.REPORT);

		assertEquals(robot.getX(), 0);
		assertEquals(robot.getY(), 1);
		assertEquals(robot.getF(), "NORTH");
		
		assertEquals(robot.getReport(), "Output: 0,1,NORTH");
	}
	
	@Test
	public void testRobotExample2() {
		Config config = new Config();
		Robot robot = new Robot(config);
		CmdResult result = new CmdResult();
		
		robot.exec("PLACE 0,0,NORTH", result);
		robot.exec("LEFT", result);
		robot.exec("REPORT", result);
		
		assertEquals(result.isValid(), true);
		assertEquals(result.getCmdType(), CmdType.REPORT);
		
		assertEquals(robot.getX(), 0);
		assertEquals(robot.getY(), 0);
		assertEquals(robot.getF(), "WEST");
		
		assertEquals(robot.getReport(), "Output: 0,0,WEST");
	}

	@Test
	public void testRobotExample3() {
		Config config = new Config();
		Robot robot = new Robot(config);
		CmdResult result = new CmdResult();
		
		robot.exec("PLACE 1,2,EAST", result);
		robot.exec("MOVE", result);
		robot.exec("MOVE", result);
		robot.exec("LEFT", result);
		robot.exec("MOVE", result);
		robot.exec("REPORT", result);
		
		assertEquals(result.isValid(), true);
		assertEquals(result.getCmdType(), CmdType.REPORT);
		
		assertEquals(robot.getX(), 3);
		assertEquals(robot.getY(), 3);
		assertEquals(robot.getF(), "NORTH");
		
		assertEquals(robot.getReport(), "Output: 3,3,NORTH");
	}

}
