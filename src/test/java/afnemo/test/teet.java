package afnemo.test;

import java.io.IOException;

/**
 * 
 * @autor: Arnold Herrera
 * @date: 1/05/2019
 * @filename: teet.java
 * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
 * 
 */

public class teet {
	public static void main(String[] args) throws IOException {
		String current = new java.io.File(".").getCanonicalPath();
		System.out.println("Current dir:" + current);
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir+"\\");
	}
}
