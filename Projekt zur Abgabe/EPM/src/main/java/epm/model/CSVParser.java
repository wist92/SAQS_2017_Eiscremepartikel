package epm.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
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
	
	/*
	 * */

	public void write(ArrayList<Station> list) throws IOException {
		PrintWriter out;
		Station s;		
		BufferedWriter bw = null;
		FileWriter fw = null;
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			String output = s.getId() + this.separator + s.getTarget();
			if (s.getActual() != 0) {
				output = output + this.separator + s.getActual() + this.separator + s.getDate();
			}
			
			CSVParser parser = new CSVParser("Stations.csv", ";");				
			ArrayList<Station> copylist = parser.read();
			if (copylist.isEmpty()) {
				System.out.println("leere file");
				fw = new FileWriter(this.pathToFile, true);
				bw = new BufferedWriter(fw);				
				bw.write(output);
			}
			else {
				System.out.println("conten was");
				copylist.add(s);
				fw = new FileWriter(this.pathToFile, true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(output);
				
			}		
			bw.close();
			fw.close();
		}
	}

}
