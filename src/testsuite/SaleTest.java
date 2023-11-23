package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SaleTest extends BaseTest
{
    static String baseUrl= "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage()
    {
      WebElement saleMenuTab = driver.findElement(By.xpath("//span[.='Sale']"));
      saleMenuTab.click();

      WebElement jacketsLinkWomen = driver.findElement(By.xpath("(//a[contains(text(),'Jackets')])[1]"));
      jacketsLinkWomen.click();

      String expectedText = "Jackets";
      WebElement actualTextElement = driver.findElement(By.xpath("(//span[contains(text(),'Jackets')])[3]"));
      String actualText =  actualTextElement.getText();
      Assert.assertEquals("Jackets" ,expectedText,actualText );

        List<WebElement> jackets = driver.findElements(By.className("product-item-info"));
        int count = jackets.size();
        System.out.println("Total number of jackets displayed on the page : " +count);

        for ( WebElement jacketNames : jackets )
        {
            System.out.println(jacketNames.getText());
            System.out.println(jacketNames.getAttribute("href"));
        }
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}

//        List<WebElement> jacketLinkNames = driver.findElements(By.tagName("a"));
//        System.out.println(jacketLinkNames);

//
//        for(int i=0;i<=count-1;i++)
//        {
//            WebElement names = jackets.get(i);                                //attribute and value
//            System.out.println(names);
//            String jacketNames = names.getAttribute("class");         //value
//            System.out.println(jacketNames);
//        }
