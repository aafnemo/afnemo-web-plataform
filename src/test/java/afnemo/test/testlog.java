package afnemo.test;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        9/04/2019
  * @filename:    testlog.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import org.junit.Test;

//import org.apache.log4j.xml.DOMConfigurator;


import com.afnemo.commons.Logsl;


public class testlog extends Logsl{
	@Test
    public void hola()
    {
        log.debug("Debug Message Logged !!!");
        log.info("Info Message Logged !!!");
        log.error("Error Message Logged !!!");
    }
}