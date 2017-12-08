package application;

import application.ViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class View {

	@FXML
	private TextField userNameTextField;

	@FXML
	private TextField passwordTextField;

	@FXML
	private Button loginButton;

	@FXML
	void initialize() {
		ViewModel vm = new ViewModel();
		userNameTextField.textProperty().bindBidirectional(vm.userNameProperty());
		passwordTextField.textProperty().bindBidirectional(vm.passwordProperty());
		loginButton.disableProperty().bind(vm.isLoginPossibleProperty().not());
}
}