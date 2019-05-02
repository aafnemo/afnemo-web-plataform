package com.afnemo.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 8/04/2019
 * @filename: CustomFileAppender.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class Logsl {
	public Logger log;
	public Logsl() {
		DOMConfigurator.configure("src/main/resources/dtds/log4j.xml");
		log = Logger.getLogger(getClass());
	}
	static {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyyMMddHH");
		SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyyMMddHHmmss");

		System.setProperty("current.date1", dateFormat1.format(new Date()));
		System.setProperty("current.date2", dateFormat2.format(new Date()));
		System.setProperty("current.date3", dateFormat3.format(new Date()));
		System.setProperty("current.date4", dateFormat4.format(new Date()));
		System.setProperty("current.date5", dateFormat5.format(new Date()));
	}
}
