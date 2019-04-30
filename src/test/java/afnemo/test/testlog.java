package afnemo.test;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        9/04/2019
  * @filename:    testlog.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import org.apache.log4j.Logger;
//import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import com.afnemo.commons.Logs;

public class testlog extends Logs {

	public void loggingtest(int i) throws InterruptedException {
		// DOMConfigurator.configure("src/main/resources/dtds/log4j.xml");
		Logger log = Logger.getLogger(getClass());

		log.trace("Prueba " + i);
		log.debug("Prueba " + i);
		log.info("Prueba " + i);
		log.warn("Prueba " + i);
		log.error("Prueba " + i);
		log.fatal("Prueba " + i);

	}
	@Test
	public void testmethod() throws InterruptedException {
		testlog n = new testlog();
		for (int i = 0; i <= 1000000; i++) {
			n.loggingtest(i);
			Thread.sleep(10000);
		}
	}
}
