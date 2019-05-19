package RegressionSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.CommonAPI;
import regression.Homepage;

public class TestHomepage  extends Homepage {
     Homepage homePage;


    @BeforeMethod
     public void init() {
        homePage = PageFactory.initElements(driver, Homepage.class);
        driver.getCurrentUrl();
    }

    //-----------Testcase 1. Testing if Input error shows up ----------


    @Test
    public void accountInputError() {
        homePage.clickAccount();
        sleepFor(3);
        homePage.getEmailOrNumber();
        homePage.getSignInPassword();
        sleepFor(5);
        WebElement inputError = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1"));
        if (inputError.isDisplayed()) {
            System.out.println("Input Error was displayed. Text: " + inputError.getText());
            getScreenshot(driver);
        } else {
            System.out.println("Failed to show InputError");
            getScreenshot(driver);
        }
        quitDriver();
    }

    //-----------Testcase 2. Testing the error message if login with invalid info ----------



    @Test
    public void accountValidEmailInput(){
        homePage.clickAccount();
        sleepFor(3);
        homePage.SignIn("myemail@gmail.com", "password");
        sleepFor(1);
        WebElement errorLoginFail = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1"));
        if (errorLoginFail.isDisplayed()){
            System.out.println("Success. Message was shown up");
            getScreenshot(driver);
        }
        else{
            System.out.println("Failed");
            getScreenshot(driver);
        }
        quitDriver();
    }

    //-----------Testcase 3. Testing the error message if login with invalid phone number info ----------


    @Test
    public void accountValidPhoneInput(){
        homePage.clickAccount();
        sleepFor(2);
        homePage.SignIn("3347-xxx-xxxx", "password");
        sleepFor(1);
        WebElement errorLoginFail = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1"));
        if (errorLoginFail.isDisplayed()){
            System.out.println("Success. Message was shown up");
            getScreenshot(driver);
        }
        else{
            System.out.println("Failed");
            getScreenshot(driver);
        }
        quitDriver();
    }

    //-----------Testcase 4. Testing Jobs one the homepage and searchbox jobs  ----------

    @Test
    public void signInButtonTest(){
        homePage.signInButton();
        sleepFor(1);
        homePage.SignIn("myemail@gmail.com", "password");
        sleepFor(1);
        WebElement errorLoginFail = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        if (errorLoginFail.isDisplayed()){
            System.out.println("Success. Message was shown up");
            getScreenshot(driver);
        }
        else{
            System.out.println("Failed");
            getScreenshot(driver);
        }
        quitDriver();
    }



    //-----------Testcase 5. Testing if Debit or Credit card needs to be provided while creating profile ----------

    @Test
    public void createAmazonAccount() {
        homePage.CreateYourAmazonAccount();
        sleepFor(1);
        driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("xyz");
        sleepFor(1);
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("myemail@gmail.com");
        sleepFor(1);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("password");
        sleepFor(1);
        driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        sleepFor(3);
        if(driver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div/h4")).getText().indexOf("important message")!=-1){
            System.out.println("Success. Message was shown up");
            getScreenshot(driver);
        } else {
            System.out.println("Failed");
            getScreenshot(driver);
        }
        quitDriver();
    }

}