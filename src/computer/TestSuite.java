package computer;
/**
 * ● Create the package name computer
 * 1. Create class “TestSuite”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
 * [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 *
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlpaBaticalOrder() {

        //1.1 Click on Computer
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort by Position "Name Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A ");
        //1.4 Verify the Product will arrange in Descending order.
        selectByValueFromDropDown(By.id("products-orderby"), "6");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        selectByValueFromDropDown(By.id("products-orderby"), "5");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        verifyFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        // String expectedTextBuildComputer = "Build your own computer";
        // String actualTextBuildComputer = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //  Assert.assertEquals("Not verifying the Text", expectedTextBuildComputer, actualTextBuildComputer);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        //2.11 Verify the price "$1,475.00"
        verifyFromElement(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top
        verifyFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        Thread.sleep(5000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 Verify the message "Shopping cart"
        verifyFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTestToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.id("updatecart"));

        //2.17 Verify the Total"$2,950.00"
        String expectedTotalPrice = "$2,950.00";
        String actualTotalPrice = getTextFromElement(By.xpath("(//strong[text()='$2,950.00'])[2]"));
        Assert.assertEquals("Not matching total", expectedTotalPrice, actualTotalPrice);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTestToElement(By.id("BillingNewAddress_FirstName"), "Prime");
        sendTestToElement(By.id("BillingNewAddress_LastName"), "Test");
        Random randomGenerator = new Random();
        int emailNum = randomGenerator.nextInt(9999);
        sendTestToElement(By.id("BillingNewAddress_Email"), "john.smith" + emailNum + "@gmail.com");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        sendTestToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTestToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "25 Granville Road");
        sendTestToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "N12 0AJ");
        sendTestToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "012345678");
        //2.23 Click on “CONTINUE”)
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.28 Fill all the details
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        sendTestToElement(By.xpath("//input[@id='CardholderName']"), "Mr J Smith");
        sendTestToElement(By.xpath("//input[@id='CardNumber']"), "5252158607699923");
        sendTestToElement(By.xpath("//select[@id='ExpireMonth']"), "2");
        sendTestToElement(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTestToElement(By.xpath("//input[@id='CardCode']"), "982");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyFromElement(By.xpath("//span[contains(text(), 'Payment Method:')]"), "Payment Method:");
        verifyFromElement(By.xpath("//span[contains(text(), 'Credit Card')]"), "Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyFromElement(By.xpath("//span[contains(text(), 'Shipping Method:')]"), "Shipping Method:");
        verifyFromElement(By.xpath("//span[contains(text(),'Next Day Air')]"), "Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        verifyFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        verifyFromElement(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}