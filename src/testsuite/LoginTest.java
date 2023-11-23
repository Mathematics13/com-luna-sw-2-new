package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    static String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException
    {
      WebElement signInLink =   driver.findElement(By.linkText("Sign In"));
      signInLink.click();
      Thread.sleep(3000);

      driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("chemistry123@gmail.com");
      Thread.sleep(3000);

      driver.findElement(By.xpath("//input[@name='login[password]' and @id='pass']")).sendKeys("chem456");
      Thread.sleep(3000);

      driver.findElement(By.xpath("(//span[contains(text(),'Sign In')])[1]")).click();

      String expectedText = "Welcome";
      WebElement actualTextElement = driver.findElement(By.xpath("(//span[contains(text(),'Welcome, Anamica Mohan!')])[1]"));
      String actualText = actualTextElement.getText();
        Assert.assertEquals("Welcome" ,expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException
    {
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

       WebElement email =  driver.findElement(By.xpath("(//input[@type='email'])[1]"));
       email.sendKeys("AnamicaMohan@gmail.com");
       Thread.sleep(3000);

        WebElement incorrectPwd =  driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        incorrectPwd.sendKeys("Anamo456");
        Thread.sleep(3000);

        WebElement signInButton =  driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signInButton.click();
        Thread.sleep(3000);

        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later." ,expectedText ,actualText);
    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException
    {
        driver.findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();

        WebElement email =  driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        email.sendKeys("AnamicaMohan@gmail.com");
        Thread.sleep(3000);

        WebElement pwd =  driver.findElement(By.xpath("(//input[@type='password'])[1]"));
        pwd.sendKeys("Anamo123");
        Thread.sleep(3000);

        WebElement signInButton =  driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signInButton.click();
        Thread.sleep(3000);

        String expectedText = "Welcome";
        WebElement actualTextElement = driver.findElement(By.xpath("(//span[contains(text(),'Welcome, Anamica Mohan!')])[1]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Welcome" ,expectedText,actualText);

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
