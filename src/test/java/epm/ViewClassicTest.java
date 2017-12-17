package epm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.testfx.api.FxRobotException;

import de.saxsys.mvvmfx.utils.itemlist.SelectableItemList;
import de.saxsys.mvvmfx.utils.itemlist.SelectableStringList;
import javafx.scene.control.TextField;

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
	@Test
	public void surchTextFliedStationID() {
		
		stationIdTextField = find("#stationIdTextField");
		dateTextField = find("#dateTextField");
		targetTextField = find("#targetTextField");
		actualTextField = find("#actualTextField");
		varianceTextField = find("#varianceTextField");
		//stationListView = find("#stationListView");
		
	}
	
}
