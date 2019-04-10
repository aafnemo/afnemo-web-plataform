package afnemo;
/**
  * 
  * @autor:       Arnold Herrera
  * @date:        10/04/2019
  * @filename:    MyTests.java
  * @Copyright (C) 2019 Asociación Afrocultural Neftalí Mosquera (afnemo)
  * 
  */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.afnemo.model.dao.PersonaDao;

public class MyTests {
	@Test
	public void querybyid() {
		PersonaDao persona = new PersonaDao();
		try {
			persona.consultarPorId("1");
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}
