package afnemo;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 7/04/2019
 * @filename: TestinLog.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class TestinLog {
	@Test
	public void loggingtest() {
		DOMConfigurator.configure("src/main/resources/dtds/log4j.xml");
		Logger log = Logger.getLogger(getClass());
		System.out.println("hola");
		log.error("prueba");
	}
}
