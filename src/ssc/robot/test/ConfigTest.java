package ssc.robot.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import ssc.robot.main.Config;

public class ConfigTest {

	@Test
	public void testConfigDefaultValue() {
		Config config = new Config();
		
		//Test Default Value
		assertEquals(config.isCaseSencitive(), true);
		assertEquals(config.isRequireInfoLog(), false);
		assertEquals(config.isRequireWarnLog(), true);
		assertEquals(config.isRequireErrorLog(), true);
		
	}
	
	@Test
	public void testConfigSetValue() {
		Config config = new Config();
		
		//Test Setter
		config.setCaseSencitive(false);
		assertEquals(config.isCaseSencitive(), false);
		config.setRequireInfoLog(true);
		assertEquals(config.isRequireInfoLog(), true);
		config.setRequireWarnLog(false);
		assertEquals(config.isRequireWarnLog(), false);
		config.setRequireErrorLog(false);
		assertEquals(config.isRequireErrorLog(), false);
		
	}
	
}
