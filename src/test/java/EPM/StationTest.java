package EPM;

import static org.junit.Assert.assertTrue;

import javax.swing.text.View;

import EPM.Station;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features = "classpath:cucumber/Station.feature")
public class StationTest {
	@Test
	 public void TestLable(String[] args) {
		 IceCreamWindow stationgui =  new IceCreamWindow();
		 assertTrue(true);
		 IceCreamWindow station = EasyMock.createNiceMock(IceCreamWindow.class);
		EasyMock.expect(station).andReturn(stationgui);		
		EasyMock.replay(station);
		//stationgui.main(args);
		EasyMock.verify(station);
		 
		 
	 }
}
