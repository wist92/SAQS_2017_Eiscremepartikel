package epm.model;

import org.junit.Assert;
import org.junit.Test;

public class StationTest {
	
	Station a = new Station("dh3jh3",53);
	Station b = new Station("dvg7o4",37);
	Station c = new Station("vgp7e",42);
	
	@Test
	public void calcVarianceTest() throws Exception {
		a.setActual(65);
		b.setActual(37);
		c.setActual(39);
		Assert.assertTrue(a.calcVariance()==12);
		Assert.assertTrue(b.calcVariance()==0);
		Assert.assertTrue(c.calcVariance()==-3);
	}
	// wie kann ein genrate Station gleich als seldst geschriebene station
	@Test
	public void generateStationTest() throws Exception{
		Station o = Station.generateStation();
		Assert.assertTrue(o.getClass()==a.getClass());
		Assert.assertFalse(o == null);	
		System.out.println("stattion");
		Station s = Station.generateStation();
		System.out.println(s.getId());
		System.out.println(s.getTarget());
	}
	
	@Test
	public void StationIdTest() {
		
	}
	
	@Test
	public void equalsTest() throws Exception {
		Station d = a; 
		Station e = new Station("dvg7o4",37);
		Assert.assertTrue(d.equals(a));
		Assert.assertTrue(e.equals(b));
		Assert.assertFalse(a.equals(b));
		
	}
}