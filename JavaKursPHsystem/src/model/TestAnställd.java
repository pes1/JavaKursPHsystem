package model;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnst�lld {

	@Test
	public void test() {
		Anst�lld anst�lld = new Tekniker("Kalle");
		
		assertTrue(anst�lld.getNamn().equals("Kalle"));
		
	}

}
