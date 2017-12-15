package epm;

import org.junit.Test;
import org.testfx.api.FxRobotException;

public class ViewClassicTest extends TestFxBase {

	final String STATIONIDTEXTFLIED = "#stationIdTextField";
	final String DATETEXTFLIED = "#dateTextField";
	final String TARGETTEXTFLIED = "#targetTextField";
	final String ACTUALTEXTFLIED = "#actualTextField";
	final String VARIANCETEXTFLIED = "#varianceTextField";
	final String STATIONLISTVIEW   ="#stationListView";

	@Test(expected = FxRobotException.class)
	public void clickOnBogusElement() {
		clickOn("#sector8");
	}
	
	public void ensureSelectedStationIdInListviewAppearOnTextFlied() {
		
	}
	
}
