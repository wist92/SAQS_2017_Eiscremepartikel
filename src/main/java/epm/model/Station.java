package epm.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Station {

	final static private char[] ZEICHEN = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private String id;
	private int target;
	private int actual;
	private String date;

	public Station(String id, int target) {
		this.id = id;
		this.target = target;
		this.actual = 0;
		this.date = "Noch kein Wert abgelesen";
	}
// id enthält immer ein Integer[0,9]+ charAlfabeth +int+ char+int und zwar von langer 7 und ne target E[0,30]+25
	public static Station generateStation() {
		String id = ZEICHEN[(int) (Math.random() * 25)] + String.valueOf((int) (Math.random() * 9 )) + ZEICHEN[(int) (Math.random() * 25)] 
				+  String.valueOf((int) (Math.random() * 9 )) + ZEICHEN[(int) (Math.random() * 25)] + String.valueOf((int) (Math.random() * 9 )) + ZEICHEN[(int) (Math.random() * 25)];
		return new Station(id, (int) (Math.random() * 30) + 25);
	}

	public int calcVariance() {
		if (this.actual == 0) {
			return 0;
		}
		return this.actual - this.target;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy kk:mm"); // Format für 24-Stunden-Anzeige
		this.date = dateFormat.format(new Date());

	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		Boolean b = false;
		Station s = (Station) o;
		if (this.getId() == s.getId()) {
			b = true;
		}
		return b;
	}
}