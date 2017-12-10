package epm.model;

public class Station {

	final static private char[] ZEICHEN = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	private String id;
	private int target;
	private int actual;
	private String date;

	public Station(String id, int target) {
		this.id = id;
		this.target = target;
		this.actual=0;
		this.date=null;
	}

	public static Station generateStation() {
		String id = String.valueOf(ZEICHEN[(int) (Math.random() * 35)] + ZEICHEN[(int) (Math.random() * 35)]
				+ ZEICHEN[(int) (Math.random() * 35)] + ZEICHEN[(int) (Math.random() * 35)]
				+ ZEICHEN[(int) (Math.random() * 35)]);
		return new Station(id, (int) (Math.random() * 30) + 25);
	}
	
	public int calcVariance() {
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
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String gc) {
		this.date = gc;
	}
	
	@Override
	public boolean equals(Object o) {
		Boolean b = false; 
		Station s = (Station) o;
		if(this.getId()== s.getId()) {
			b = true;
		}
		return b;
	}
}