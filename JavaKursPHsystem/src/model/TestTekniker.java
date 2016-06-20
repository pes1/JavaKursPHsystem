package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTekniker {
	
	String testNamn = "Kalle";

	@Test
	public void test() {
		Tekniker tekniker = new Tekniker("testNamn");
		
		assertTrue(tekniker.getNamn() == "testNamn");
		
		assertTrue(tekniker.getBasM�nadsL�n() == 27000);
		
		tekniker.setUppTid(.9);
		
		assertTrue(tekniker.getBonus() == 1800);
	}

}
