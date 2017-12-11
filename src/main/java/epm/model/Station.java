package epm.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Station {

	final static private char[] ZEICHEN = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

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

	public static Station generateStation() {
		String id = String.valueOf(ZEICHEN[(int) (Math.random() * 35)] + ZEICHEN[(int) (Math.random() * 35)]
				+ ZEICHEN[(int) (Math.random() * 35)] + ZEICHEN[(int) (Math.random() * 35)]
				+ ZEICHEN[(int) (Math.random() * 35)]);
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