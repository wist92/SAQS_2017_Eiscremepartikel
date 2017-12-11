package epm;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClassic extends Application {

//	final static Logger logger = Logger.getLogger(MainClassic.class.getName());

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ViewClassic.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		
		// Logging für fehler und infoausgaben auf der Konsole und der Datei EPM-log4j
		// positiv für testability und availabilty
		
		//logger.debug("This is debug : MainClassic");

		//logger.info("This is info : MainClassic");

		//logger.warn("This is warn : MainClassic");
		//logger.error("This is error : MainClassic");
		// logger.error("This is error : MainClassic"+exception);
		//logger.fatal("This is fatal : MainClassic");
	}

	public static void main(String[] args) {
		launch(args);
	}

}