package epm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Model {

	private ArrayList<Station> stations;
	private CSVParser parser;

	public Model() {
		this.stations = new ArrayList<>();
		Station s = Station.generateStation();
		s.setActual(34);
		this.stations.add(s);
		this.stations.add(Station.generateStation());
		this.stations.add(Station.generateStation());
		this.stations.add(Station.generateStation());
		
		// this.p/arser = new CSVParser("resources/Stations.csv",";");
		// stations = parser.read();
		// stations.forEach((k,v) -> v.calcVariance());
	}

	public int getAnzStations() {
		return this.stations.size();
	}
	
	public void setStation(Station station) {
		for ( Iterator<Station> it = this.stations.iterator(); it.hasNext(); ){
			Station s = it.next();
			if (s.equals(station)) {
				it.remove();
			}
		}
		this.stations.add(station);
	}

	public Station getStation(int index) {
		return this.stations.get(index);
	}

	public Station getStation(String id) {		
		for ( Iterator<Station> it = this.stations.iterator(); it.hasNext(); ){
			Station s = it.next();
			if (s.equals(new Station(id, 0))) {
				return s;
			}
		}
		return null;
	}
}
