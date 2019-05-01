package com.afnemo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 1/05/2019
 * @filename: StartWebApp.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class StartWebApp {
	public static void main(String[] args) throws Exception {
		String portStr = System.getenv("PORT");
		int port = (portStr == null) ? 8085 : Integer.parseInt(portStr);
		Server server = new Server(port);
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		// change the name of the war as needed.
		webapp.setWar("target/AFNEMO.war");
		server.setHandler(webapp);

		server.start();
		server.join();
	}
}
