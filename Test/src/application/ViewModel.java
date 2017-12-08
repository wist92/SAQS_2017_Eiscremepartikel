package application;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel{


	private final StringProperty userName = new SimpleStringProperty();
	private final StringProperty password = new SimpleStringProperty();
	private final ReadOnlyBooleanWrapper loginPossible = new ReadOnlyBooleanWrapper();

	public ViewModel() {
		loginPossible.bind(userName.isNotEmpty().and(password.isNotEmpty()));
	}

	public StringProperty userNameProperty() {
		return userName;
	}

	public StringProperty passwordProperty() {
		return password;
	}

	public ReadOnlyBooleanProperty isLoginPossibleProperty() {
		return loginPossible.getReadOnlyProperty();
}
}