package model;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnställd {

	@Test
	public void test() {
		Anställd anställd = new Tekniker("Kalle");
		
		assertTrue(anställd.getNamn().equals("Kalle"));
		
	}

}
