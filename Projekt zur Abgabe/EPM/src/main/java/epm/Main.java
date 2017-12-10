package epm;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	final static Logger logger = Logger.getLogger(Main.class.getName());

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/View.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

		
		// Logging für fehler und infoausgaben auf der Konsole und der Datei EPM-log4j
		// positiv für testability und availabilty
		
		logger.debug("This is debug : Main");

		logger.info("This is info : Main");

		logger.warn("This is warn : Main");
		logger.error("This is error : Main");
		// logger.error("This is error : Main"+exception);
		logger.fatal("This is fatal : Main");
	}

	public static void main(String[] args) {
		launch(args);
	}

}