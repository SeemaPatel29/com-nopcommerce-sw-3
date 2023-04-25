package utility;

import basetest.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    //by is variable name

    public void clickOnElement(By by){
        driver.findElement(by).click();
        // WebElement loginLink = driver.findElement(by);// instead of this 2 lines
        // loginLink.click();
    }

    //method will send test to element
    public void sendTestToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
        // WebElement emailField = driver.findElement(by);
        // emailField.sendKeys(text);

    }

    // this method will get text from element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }

    public String getActualTextFromElement(By by){
        return driver.findElement(by).getText();
    }
   /* public void verifyFromElement(By by, String text){
        String expextedMessage = text;
        WebElement actualelement = driver.findElement(by);
        String actualmessage = actualelement.getText();
        Assert.assertEquals(expextedMessage,actualmessage);*/
//**************************Alert Method*******************************
    //Homework Creat 5 Methods
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    public void accept(){
        driver.switchTo().alert().accept();
    }
    public void  dismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alertGetText(){
        driver.switchTo().alert().getText();

    }
    public void alertSendKeys(String text){
        driver.switchTo().alert().sendKeys(text);

    }
    public void verifyFromElement(By by, String text) {
        String expextedMessage = text;
        WebElement actualelement = driver.findElement(by);
        String actualmessage = actualelement.getText();
        Assert.assertEquals(expextedMessage, actualmessage);
    }


    //**********************Select Method******************************
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String text){
        WebElement dropeDown = driver.findElement(by);
        Select select = new Select(dropeDown);
        select.selectByValue(text);
    }
    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropeDown = driver.findElement(by);
        Select select = new Select(dropeDown);
        select.selectByIndex(index);
    }
    public void selectOptionByContainsText(By by) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        List<WebElement> list = select.getOptions();

    }
    //************************************************** Window Handle **********************************************************
    //************************************************** Action Class ***********************************************************
    //  mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void tearDown() {
        closeBrowser();
    }
}

