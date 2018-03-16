package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.FacebookHomePage;
import framework.FacebookLoginPage;
import org.testng.Assert;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class FacebookLoginSD {

    private FacebookHomePage facebookHomePage = new FacebookHomePage();
    private FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                facebookHomePage.enterEmail(anyText);
                break;
            case "password":
                facebookHomePage.enterPassword(anyText);
                break;
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

    @When("^I click on (login button|create account button|Data Policy link|Sign Up button) on home screen$")
    public void clickOnLoginButton(String button) throws InterruptedException {

        switch (button) {
            case "login button":
                facebookHomePage.clickOnLoginButton();
                break;
            case "create account button":
                facebookHomePage.clickOnCreateAccount();
                break;
            case "Data Policy link":
                facebookHomePage.clickOnDataPolicyLink();
                break;
            case "Sign Up button":
                facebookHomePage.clickOnSignUpButtonOnPrivacyPage();
        }
    }

    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(facebookLoginPage.getPageHeader(), "Log into Facebook");
    }

    @Then("^I see number [0-9] in text field$")
    public void textField(int num) {

    }

    @When("^I switch the WebDriver to new window and verify page title$")
    public void switchDriverToNewWindow() {
        facebookHomePage.switchToWindow(1);
        Assert.assertEquals(facebookHomePage.getTitle(), "Data Policy");
    }

    @When("^I close the current window and come back to the root window$")
    public void switchDriverBackToHomePage() {
        facebookHomePage.switchToRootWindowAndCloseCurrentWindow();
    }

    @Then("^I verify that i am on home page$")
    public void verifyHomePageTitle() {
        Assert.assertEquals(facebookHomePage.getTitle(), "Facebook - Log In or Sign Up");
    }

}
