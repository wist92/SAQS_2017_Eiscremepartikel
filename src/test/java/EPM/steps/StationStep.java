package EPM.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import EPM.Station;

import static org.assertj.core.api.Assertions.assertThat;

public class StationStep {

	    Boolean exceptionWasThrown = false;
	    Station s = null;
	    int value = 0;

	    @Given("^a station with value (.*)$")
	    public void givenAStation(Station st) {
	        s = st;
	    }

	    @When("^getter called with value$")
	    public void getValue() {
//	        value = Station.get();
	    }

	    @Then("^text is a palindrome$")
	    public void textIsAPalindrome() {
//	        assertThat(isPalindrome).isEqualTo(true);
	    }

	    @Then("^text is not a palindrome$")
	    public void textIsNotAPalindrome() {
//	        assertThat(isPalindrome).isEqualTo(false);
	    }
	}

