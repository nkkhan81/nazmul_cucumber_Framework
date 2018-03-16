package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.ExpediaHomePage;
import org.testng.Assert;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class ExpediaAutoCompleteSD {

    private ExpediaHomePage expedia = new ExpediaHomePage();

    @Given("^I am on Expedia home page$")
    public void iAmOnExpediaHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations", "Invalid Home Page");
    }

    @When("^I click on (Flight tab|Flying from field) on home page$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "Flight tab":
                expedia.clickOnFlightTab();
                break;
            case "Flying from field":
                expedia.clickOnFlyingFrom();
                break;
        }
    }

    @When("^I insert (new york) into Flying from field on home page$")
    public void enterCityIntoTextFields(String city) {
        expedia.insertTextOnFlyingFrom(city);
    }

    @When("^I click on JFK airport from list$")
    public void clickOnItemFromSuggestion() throws InterruptedException {
        expedia.selectAirport("(JFK) John F. Kennedy Intl.");
    }

    @Then("^I verify JFK airport has been selected$")
    public void verifySelectedAirport() {
        expedia.verifyAirport();
    }
}
