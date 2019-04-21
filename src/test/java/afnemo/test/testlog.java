package afnemo.test;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        9/04/2019
  * @filename:    testlog.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

//import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import com.afnemo.commons.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class testlog extends Logs{
    private static final Logger LOGGER = LogManager.getLogger(testlog.class.getName());
     
    public static void main(String[] args)
    {
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
        LOGGER.error("Error Message Logged !!!");
    }
}