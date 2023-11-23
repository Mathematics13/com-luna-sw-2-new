package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class RegisterTest extends BaseTest
{
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException
    {
        WebElement createAnAccount = driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]"));
        createAnAccount.click();
        Thread.sleep(3000);

     String expectedText = "Create New Customer Account";
     WebElement  actualTextElement = driver.findElement(By.xpath("//span[.='Create New Customer Account']"));
     String actualText =  actualTextElement.getText();
     Assert.assertEquals("Create New Customer Account", expectedText ,actualText );
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException
    {
        Random randomGenerator = new Random();                                                           //Object for Random Class
        int randomInt = randomGenerator.nextInt(10);

        WebElement createAnAccount = driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]"));
        createAnAccount.click();
        Thread.sleep(3000);

        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Anamica" +randomInt);
        Thread.sleep(3000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
        lastName.sendKeys("Mohan" +randomInt);
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.xpath("//input[@id='email_address']"));
        email.sendKeys("AnamicaMohan@gmail.com");
        Thread.sleep(3000);

        WebElement pwd = driver.findElement(By.xpath("//input[@name='password'][1]"));
        pwd.sendKeys("Anamo123");
        Thread.sleep(3000);

        WebElement confirmPwd = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
        confirmPwd .sendKeys("Anamo123");
        Thread.sleep(3000);

        WebElement createAnAccount1 = driver.findElement(By.xpath("(//span[contains(text(),'Create an Account')])[1]"));
        createAnAccount1.click();
        Thread.sleep(3000);

        String expectedText = "Thank you for registering with Main Website Store";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Thank you for registering with Main Website Store",expectedText,actualText);

        WebElement downArrow = driver.findElement(By.xpath("(//button[@class='action switch'])[1]"));
        downArrow .click();
        Thread.sleep(3000);

        WebElement signOut = driver.findElement(By.xpath("(//a[contains(text(),'Sign Out')])[1]"));
        signOut.click();
        Thread.sleep(3000);

        String expectedText1 = "You are signed out";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//span[.='You are signed out']"));
        String actualText1 = actualTextElement1.getText();
        Assert.assertEquals("You are signed out" ,expectedText1 ,actualText1);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
