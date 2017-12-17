package epm;

import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public abstract class TestFxBase extends ApplicationTest {

	@Before
	public void setUp() throws Exception {
		ApplicationTest.launch(MainClassic.class);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.show();
	}
	
	@After
	public void afterEachTest() throws TimeoutException {
		FxToolkit.hideStage();
		release(new KeyCode[] {});
		release(new MouseButton[]{});
	}
	
	/* Helper method to retrieve java Fx GUI component*/
	public <T extends Node> T find(final String query) {
		return (T) lookup(query).queryAll().iterator().next();
	}
}
