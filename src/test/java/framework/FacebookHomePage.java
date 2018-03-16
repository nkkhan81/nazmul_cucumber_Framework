package framework;

import org.openqa.selenium.By;
import org.testng.Assert;

public class FacebookHomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.xpath("//input[@name='firstname']");
	private By lastNameTextField = By.xpath("//input[@name='lastname']");
	private By mobileNumberTextField = By.xpath("//input[@name='reg_email__']");
	private By newPasswordTextField = By.xpath("//input[contains(@autocomplete,'new')]");
	private By selectMonthField = By.cssSelector("select#month");
	private By selectDayField = By.cssSelector("select#day");
	private By selectYearField = By.cssSelector("select#year");
	private By errorMessage = By.id("errorMessage");
	private By createAccountButton = By.cssSelector("button[name='websubmit']");
	By maleRadioButton = By.xpath("//span[@data-name='gender_wrapper']/span[2]/input[1]");
	private By dataPolicyLink = By.xpath("//a[@id='privacy-link']");
	private By signUpButtonOnPrivacyPage = By.linkText("Sign Up");
	private By genderErrorMessageField = By.xpath("//div[@class='uiContextualLayer uiContextualLayerLeft']/div/div");

	//individual method
	public boolean isSelectedMaleRadioButton(){
		boolean isSelected = isElementSelected(maleRadioButton);
		return isSelected;
	}

	public void clickOnMaleRadioButton(){
		if (isSelectedMaleRadioButton() == false){
			clickOn(maleRadioButton);
		}
	}

	public void verifySelectionOfRadioButton(){
		boolean isSelected = isElementSelected(maleRadioButton);
		String booleanValue = null;
		if (isSelected == true){
			booleanValue = "true";
		}
		Assert.assertEquals(booleanValue,"true");
	}
	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

	public void enterEmail(String enterEmail) {
		sendText(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		sendText(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		sendText(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		sendText(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		sendText(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		sendText(newPasswordTextField, password);
	}

	public void selectMonthFromDropdown(String visibleTextOfMonth){
		selectDropDownMenuByVisibleText(selectMonthField, visibleTextOfMonth);
	}

	public void selectDayFromDropdown(String day){
		selectDropDownMenuByVisibleText(selectDayField, day);
	}

	public void selectYearFromDropdown(String year){
		selectDropDownMenuByVisibleText(selectYearField, year);
	}


	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public void clickOnCreateAccount(){
		clickOn(createAccountButton);
	}

	public void clickOnDataPolicyLink() throws InterruptedException {
//		BasePaseJS.ScrollDownPage(0,200);
		clickOn(dataPolicyLink);
	}

	public void clickOnSignUpButtonOnPrivacyPage(){
		clickOn(signUpButtonOnPrivacyPage);
	}

	public void verifyGenderErrorMessage(){
		Assert.assertEquals(getTextFromElement(genderErrorMessageField),"Please choose a gender. You can change who can see this later.");
	}

}
