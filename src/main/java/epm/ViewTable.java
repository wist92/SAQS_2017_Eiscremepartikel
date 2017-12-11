package epm;

import epm.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewTable {
	
	@FXML
	TableView table = new TableView();
	
	@FXML
	TableColumn idcolumn = new TableColumn();
	
	
	@FXML
	void initialize() {
		ViewModel vm = new ViewModel();
		idcolumn.setCellFactory(vm.getTableStationId());
	

		
	}
}
