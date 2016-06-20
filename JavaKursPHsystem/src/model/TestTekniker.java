package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTekniker {

	@Test
	public void test() {
		Tekniker tekniker = new Tekniker("Kalle");
		
		assertTrue(tekniker.getNamn() == "Kalle");
		
		assertTrue(tekniker.getBaslön() == 27000);
	}

}
