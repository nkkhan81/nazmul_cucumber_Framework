package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AmazonHomePage;
import org.testng.Assert;

/**
 * Created by nkkhan on 2/10/18.
 */
public class amazonLoginSD {
    private AmazonHomePage amazonHomePage = new AmazonHomePage();

    @Given("^I am on home page of Amazon$")
    public void iAmOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", "Invalid Home Page");
    }

    @When("^I Hover over to Accounts & List$")
    public void hoverOverToAccountAndList(){
        amazonHomePage.mouseOverOnAccount();
    }

    @When("^I enter (.+) into (email address|password) field$")
    public void insertTextInInputField(String anyText, String textFields) {

        switch (textFields) {
            case "email address":
                amazonHomePage.insertEmail(anyText);
                break;
            case "password":
                amazonHomePage.insertPassword(anyText);
                break;
        }
    }


    @When("^I click on (continue|Sign in|SignIn) button$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "continue":
                //sometimes instead of continue button, password field and SignIn button appears.
                //in that case inserting password and clicking on SignIn button then verifying error message
                //otherwise simply clicking on Continue button.
                if (amazonHomePage.isPassFieldExists() == true){
                    amazonHomePage.insertPassword("test123");
                    amazonHomePage.clickOnSignIn();
                }else {
                    amazonHomePage.clickOnContinueButton();
                }
                break;
            case "Sign in":
                amazonHomePage.clickOnSignInButtonOnMouseOverArea();
                break;
            case "SignIn":
                amazonHomePage.clickOnSignIn();
                break;
        }
    }


    @Then("^I verify invalid error message$")
    public void verifyErrorMesseges(){
        Assert.assertEquals(amazonHomePage.getWarningMessage(),"There was a problem We cannot find an account with that email address","Invalid message");
    }
}
