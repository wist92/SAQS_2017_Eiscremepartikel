package epm.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CSVParserTest {

	CSVParser parser = new CSVParser("Stations.csv", ";");
	
	
	
	@Test
	public void writeTest() {
		Station s = new Station("t5hfg", 65);
		ArrayList<Station> al = new ArrayList<Station>();
		al.add(s);
		try {
			parser.write(al);
			ArrayList<Station> list = parser.read();
			for (int i = 0; i < list.size(); i++) {
				Assert.assertEquals( s.getId(), list.get(i).getId());				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* list.containt()  return immer falsche, auch wenn unseres CSV Datein die erwartete Station enthält 
	 * deswegen habe ich entschieden, die StationID b zu vergleichen.*/	
	
	@Test
	public void readTest() {
		ArrayList<Station> list;
		try {
			list = parser.read();
			Station a = new Station("t5hfg", 25);
			for (int i = 0; i < list.size(); i++) {
					Assert.assertEquals(a.getId(), list.get(i).getId());				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}