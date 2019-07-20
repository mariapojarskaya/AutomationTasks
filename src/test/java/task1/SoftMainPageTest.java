package task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static java.lang.System.setProperty;

public class SoftMainPageTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void softMainPageTest(){

        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //1. Open test site by URL
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/");

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement userNameTitle = driver.findElement(By.cssSelector("div.profile-photo > span"));
        softAssert.assertEquals(userNameTitle.getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> upperToolbarItems = driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));
        softAssert.assertEquals(upperToolbarItems.size(), 4);
        for (WebElement item : upperToolbarItems) {
            softAssert.assertTrue(item.isDisplayed());
        }
        softAssert.assertEquals(upperToolbarItems.get(0).getText(), "HOME");
        softAssert.assertEquals(upperToolbarItems.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(upperToolbarItems.get(2).getText(), "SERVICE");
        softAssert.assertEquals(upperToolbarItems.get(3).getText(), "METALS & COLORS");


        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> testedImages = driver.findElements(By.cssSelector("div.benefit-icon > span"));
        softAssert.assertEquals(testedImages.size(), 4);
        for (WebElement image : testedImages) {
            softAssert.assertTrue(image.isDisplayed());

        }

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> testedText = driver.findElements(By.cssSelector("div.benefit > span"));
        softAssert.assertEquals(testedText.size(), 4);
        softAssert.assertEquals(testedText.get(0).getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        softAssert.assertEquals(testedText.get(1).getText(),
                "To be flexible and\n" +
                        "customizable");
        softAssert.assertEquals(testedText.get(2).getText(),
                "To be multiplatform");
        softAssert.assertEquals(testedText.get(3).getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

        //9. Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        softAssert.assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement mainTxt = driver.findElement(By.cssSelector("p.main-txt"));
        softAssert.assertEquals(mainTxt.getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT " +
                "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM " +
                "DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement((By.cssSelector("iframe")));
        softAssert.assertTrue(frame.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(frame);
        WebElement frameLogo = driver.findElement(By.cssSelector("div.epam-logo > a > img"));
        softAssert.assertTrue(frameLogo.isDisplayed());

        //12. Switch to original window back
        driver.switchTo().parentFrame();

        //13. Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3.text-center > a"));
        softAssert.assertTrue(subHeader.isDisplayed());

        //14. Assert that JDI GITHUB is a link and has a proper URL
        String subHeadLink = driver.findElement(By.cssSelector("h3.text-center > a")).getAttribute("href");
        softAssert.assertEquals(subHeadLink, "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.cssSelector("div.mCustomScrollBox"));
        softAssert.assertTrue(leftSection.isDisplayed());

        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.cssSelector("footer"));
        softAssert.assertTrue(footer.isDisplayed());
        softAssert.assertAll();

        //17. Close Browser
        driver.close();
    }

}
