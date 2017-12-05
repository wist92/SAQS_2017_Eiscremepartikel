package EPM;

import static org.junit.Assert.assertTrue;
import EPM.Station;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features = "classpath:cucumber/Station.feature")
public class StationTest {
}
