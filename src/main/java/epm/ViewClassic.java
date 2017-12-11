package epm;

import epm.ViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewClassic {
	
	@FXML
	private TextField stationIdTextField;

	@FXML
	private TextField dateTextField;
	
	@FXML
	private TextField targetTextField;
	
	@FXML
	private TextField actualTextField;
	
	@FXML
	private TextField varianceTextField;
	
	@FXML
	private ListView<String> stationListView = new ListView<String>();

	@FXML
	private Button applyButton;

	@FXML
	void applyButtonPushed() {
		
	}
	
	@FXML
	void initialize() {
		ViewModel vm = new ViewModel();
		
		stationIdTextField.textProperty().bindBidirectional(vm.getStationIdProperty());
		dateTextField.textProperty().bindBidirectional(vm.getDateProperty());
		targetTextField.textProperty().bindBidirectional(vm.getTargetProperty());
		actualTextField.textProperty().bindBidirectional(vm.getActualProperty());
		varianceTextField.textProperty().bind(vm.getVarianceProperty());
		varianceTextField.styleProperty().bind(vm.getVarianceColor());
		
	//	applyButton
		applyButton.disableProperty().bind(vm.isApplyPossibleProperty().not());
		
		stationListView.itemsProperty().bind(vm.getIdListProperty());
		stationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		stationListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			
			
			/**
			 * oldValue -> previously selected item (not important now)
			 * newValue -> currently selected item
			 * ins ViewModel !!!S
			 */
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        vm.getStation(newValue);
		        
		        //ohne actionlistener oder ins ViewModel
		        
		        //variancefarbe setzen
		        //über logger ausgeben!
		        //System.out.println("Selected item: " + newValue);
		    }
		});
}
}