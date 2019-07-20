package task2.ex1;

import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DataProvidersAssertingTests extends TestBase {

    @Test(dataProvider = "checkIndexPageByDataProvider", dataProviderClass = DataProviders.class)
    public void checkTextWithImagesOnTheIndexPage(int textNum, String textExpected) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2. Assert that 4 texts are under 4 pictures on the Index Page
        List<WebElement> textsUnderIconsElements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIconsElements.get(textNum).getText(), textExpected);
        assertEquals(textsUnderIconsElements.size(), 4);
        driver.close();

    }
}
