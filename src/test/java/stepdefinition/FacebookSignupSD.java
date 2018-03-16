package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BasePage;
import framework.FacebookHomePage;
import org.testng.Assert;

/**
 * Created by nkkhan on 2/12/18.
 */
public class FacebookSignupSD extends BasePage{
    FacebookHomePage facebookHomePage = new FacebookHomePage();

    @Given("^I am on facebook home page$")
    public void iAmOnFacebookHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I verify male radio button is already Selected$")
    public void isRadioButtonSelected() {
        facebookHomePage.isSelectedMaleRadioButton();
    }

    @When("^I select male radio button$")
    public void clickOnMaleRadioButton() {
        facebookHomePage.clickOnMaleRadioButton();
    }

    @When("^I enter (.+) into (firstname|lastname|mobile number|new password) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {

            case "firstname":
                facebookHomePage.enterFirstName(anyText);
                break;
            case "lastname":
                facebookHomePage.enterLastName(anyText);
                break;
            case "mobile number":
                facebookHomePage.enterMobileNumber(anyText);
                break;
            case "new password":
                facebookHomePage.enterNewPassword(anyText);
                break;
        }
    }

    @When("^I select (.*) from the (month|day|year) drop down menu for birthday$")
    public void selectBirthday(String value, String dropdown){
        switch (dropdown){
            case "month":
                facebookHomePage.selectMonthFromDropdown(value);
                break;
            case "day":
                facebookHomePage.selectDayFromDropdown(value);
                break;
            case "year":
                facebookHomePage.selectYearFromDropdown(value);
                break;
        }
    }

    @Then("^I verify male radio button is selected$")
    public void verifyButtonIsSelected() {
        facebookHomePage.verifySelectionOfRadioButton();
    }

    @Then("^I verify invalid gender error message$")
    public void verifySignUpErrorMessage() {
        facebookHomePage.verifyGenderErrorMessage();
    }

}
