package epm.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class CSVParser {

	private String pathToFile;
	private String separator;

	public CSVParser(String pathToFile, String separator) {
		this.pathToFile = pathToFile;
		this.separator = separator;

	}

	// @Override
	public ArrayList<Station> read() throws FileNotFoundException {
		File csvFile = new File(this.pathToFile);
		ArrayList<Station> result = new ArrayList<Station>(50);
		Scanner inputStream;
		String[] values = null;

		inputStream = new Scanner(csvFile);

		while (inputStream.hasNext()) {
			String line = inputStream.next();
			values = line.split(this.separator);
			Station s = new Station(values[0], Integer.parseInt(values[1]));
			if (values.length > 2) {
				s.setActual(Integer.parseInt(values[2]));
				s.setDate(values[3]);
			}
			result.add(s);
		}
		inputStream.close();
		return result;
	}

	public void write(ArrayList<Station> list) throws IOException {
		PrintWriter out;
		Station s;
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			String output = s.getId() + this.separator + s.getTarget();
			if (s.getActual() != 0) {
				output = output + this.separator + s.getActual() + this.separator + s.getDate();
			}

			out = new PrintWriter(new BufferedWriter(new FileWriter(this.pathToFile, true)));
			out.println(output);

		}
	}

}
