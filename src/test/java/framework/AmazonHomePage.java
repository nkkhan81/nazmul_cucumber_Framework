package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by nkkhan on 2/10/18.
 */
public class AmazonHomePage extends BasePage{

    private By accountAndList = By.xpath("//*[@id='nav-tools']/descendant::a[2]");
    private By mouseOverSignInButton = By.id("nav-flyout-ya-signin");
    private By emailField = By.id("ap_email");
    private By continueButton = By.cssSelector("input[id='continue'");
    private By passwordField = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
    private By warningHeader = By.className("a-alert-heading");
    private By warningBody = By.className("a-list-item");


    //individual method
    public void mouseOverOnAccount() {
        mouseOver(accountAndList);
    }
    public void clickOnSignInButtonOnMouseOverArea(){
        clickOn(mouseOverSignInButton);
    }

    public void insertEmail(String email){
        doubleClicOn(emailField);
        sendText(emailField,email);
    }

    public void clickOnContinueButton(){
        clickOn(continueButton);
    }

    public void insertPassword(String password){
        sendText(passwordField,password);
    }
    public WebElement passField(){
        return getDriver().findElement(passwordField);
    }
    public boolean isPassFieldExists(){
        int count = getDriver().findElements(passwordField).size();
        if (count <= 0){
            return false;
        }else {
            return true;
        }
    }

    public void clickOnSignIn(){
        clickOn(signInButton);
    }

    //combineMethod
    public void mouseOverSignIn(String email, String password) {
        mouseOverOnAccount();
        insertEmail(email);
        insertPassword(password);
        clickOnSignIn();
    }

    public String getWarningMessage(){
        String header = getTextFromElement(warningHeader);
        String body = getTextFromElement(warningBody);
        return header+" "+body;
    }
}
