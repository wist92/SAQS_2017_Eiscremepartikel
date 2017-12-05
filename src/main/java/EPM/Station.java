package EPM;

public class Station {
	
	private String id;
	private int target;
	private int actual;
	
	public Station(String id, int target) {
		this.id=id;
		this.target=target;
	}

	public int calcVariance() {
		return this.actual-this.target;
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
}