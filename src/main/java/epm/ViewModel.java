package epm;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

import epm.model.Model;
import epm.model.Station;
import javafx.beans.property.ListProperty;

public class ViewModel {

	private StringProperty stationId = new SimpleStringProperty();
	private StringProperty date = new SimpleStringProperty();
	private StringProperty target = new SimpleStringProperty();
	private StringProperty actual = new SimpleStringProperty();
	private StringProperty variance = new SimpleStringProperty();
	
	private ListProperty<Station> stationlist = new SimpleListProperty<Station>();
	private ListProperty<String> idlist = new SimpleListProperty<String>();

	private Model model;

	private final ReadOnlyBooleanWrapper applyPossible = new ReadOnlyBooleanWrapper();

	public ViewModel() {
		// Model initialisieren und alles auf das erste Element stellen
		this.model = new Model();

		
		
		
		
		
		
		
		ArrayList<Station> list = new ArrayList<Station>();
		this.stationlist.set(FXCollections.observableArrayList(list));
		ArrayList<String> listid = new ArrayList<String>();
		this.idlist.set(FXCollections.observableArrayList(listid));
		for (int i = 0; i < this.model.getAnzStations(); i++) {
			this.stationlist.getValue().add(model.getStation(i));
			this.idlist.getValue().add(model.getStation(i).getId());
		}

		applyPossible.bind(stationId.isNotEmpty().and(target.isNotEmpty()));
	}

	public StringProperty getStationIdProperty() {
		return this.stationId;
	}

	public StringProperty getDateProperty() {
		return this.date;
	}

	public StringProperty getTargetProperty() {
		return this.target;
	}

	public StringProperty getActualProperty() {
		return this.actual;
	}

	public StringProperty getVarianceProperty() {
		return this.variance;
	}

	public ListProperty<Station> getStationListProperty() {
		return this.stationlist;
	}
	
	public ListProperty<String> getIdListProperty(){
		return this.idlist;
	}

	public void setStationId(StringProperty stationId) {
		this.stationId = stationId;
	}

	public void setDate(StringProperty date) {
		this.date = date;
	}

	public void setTarget(int target) {
		this.target.set(Integer.toString(target));
	}

	public void setActual(int actual) {
		this.actual.set(Integer.toString(actual));
	}

	public void setVariance(int variance) {
		this.variance.set(Integer.toString(variance));
	}

	public void setStationlist(ListProperty<Station> stationlist) {
		this.stationlist = stationlist;
	}

	public void getStation(String id) {
		Station s = this.model.getStation(id);
		this.stationId.set(s.getId());
		this.date.set(s.getDate());
		this.target.set(Integer.toString(s.getTarget()));
		this.actual.set(Integer.toString(s.getActual()));
		this.variance.set(Integer.toString(s.calcVariance()));

	}

//	public void setStation() {
//		Station s = new Station(this.stationId.get(), Integer.parseInt(this.target.get()));
//		if (this.actual.get() != "") {
//			s.setActual(Integer.parseInt(this.actual.get()));
//		}
//		this.model.setStation(s);
//		if (!this.stationlist.contains(this.stationId.get())) {
//			this.stationlist.getValue().add(this.stationId.get());
//		}
//	}

	public ReadOnlyBooleanProperty isApplyPossibleProperty() {
		return applyPossible.getReadOnlyProperty();
	}

	public StringProperty getVarianceColor() {
		System.out.println("called");
		StringProperty result = new SimpleStringProperty();
		if (target.get() == null || actual.get() == null) {
			result.setValue("fx-text-iner-color: grey");
		} else {
			double variancePercent = Double.parseDouble(actual.get()) / Double.parseDouble(target.get()) * 100;
			if (variancePercent <= 90) {
				result.setValue("-fx-text-inner-color: red");
			} else if (variancePercent >= 105) {
				result.setValue("-fx-text-inner-color: lime");
			} else {
				result.setValue("-fx-text-inner-color: grey");
			}
		}
		return result;
	}

	public PropertyValueFactory<Station, String> getTableStationId() {
		PropertyValueFactory<Station,String> result = new PropertyValueFactory("id");
		return result;
	}
}