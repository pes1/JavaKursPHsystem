package model;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestReceptionist {

	String testNamn = "ReceptionsNisse";

	@Test
	public void test() {
		Receptionist r = new Receptionist("testNamn");
		
		assertTrue(r.getNamn() == "testNamn"); //dvs inte "ReceptionsNisse"		
		assertTrue(r.getBasMånadsLön() == 22000);
		assertTrue(r.getBasMånadsBonus() == 1000);
		assertTrue(r.getBonus() == 2000);		
		assertTrue(r.getMånadsLön() == 24000);
		
		r.setBetyg(2);
		assertTrue(r.calcKundnöjdhet() == 0.2);
		r.setBetyg(4);
		assertTrue(r.calcKundnöjdhet() == 0.6 );
		for (int i= 0; i<10; i++){
			r.setBetyg(5);
		}
		assertTrue(r.calcKundnöjdhet() == 5);
	}
}

