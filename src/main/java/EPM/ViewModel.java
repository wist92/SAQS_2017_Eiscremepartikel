package EPM;

import java.util.Observable;

import EPM.Station;

public class ViewModel extends Observable{

	
	public void Methode1() {
		setChanged();
		notifyObservers();
	}
	
}
