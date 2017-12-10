package epm.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class CSVParserTest {

	CSVParser parser = new CSVParser("Stations.csv", ";");

	@Test
	public void readTest() {
		ArrayList<Station> list;
		try {
			list = parser.read();
			Station a = new Station("t3j5g", 47);
			Station b = new Station("kdfg3", 34);
			Assert.assertTrue(list.contains(a) && list.contains(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeTest() {
		Station s = new Station("fgu3f", 46);
		ArrayList<Station> al = new ArrayList<Station>();
		al.add(s);
		try {
			parser.write(al);
			ArrayList<Station> list = parser.read();
			Assert.assertTrue(list.contains(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
