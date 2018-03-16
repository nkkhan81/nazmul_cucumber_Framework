package framework;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by nkkhan on 2/13/18.
 */
public class ExpediaHomePage extends BasePage {

    //locators
    private By flightTab = By.xpath("id('wizard-tabs')/div[1]/ul/descendant::li[1]");
    private By originFlightField = By.xpath("//*[@id='flight-origin-hp-flight']");
    private By autoCompleteList = By.className("results-item");


    //methods
    public void clickOnFlightTab(){
        clickOn(flightTab);
    }
    public void clickOnFlyingFrom(){
        clickOn(originFlightField);
    }
    public void insertTextOnFlyingFrom(String text){
        sendText(originFlightField,text);
    }
    public void selectAirport(String searchText) throws InterruptedException {
        selectFromAutoCompleteMenu(autoCompleteList,searchText);
    }
    public void verifyAirport(){
        Assert.assertTrue(getText.contains("John F. Kennedy Intl."));
    }
}
