package task3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPageSelenium;

import java.util.concurrent.TimeUnit;

import static enums.Titles.HOME_PAGE_TITLE;
import static enums.Titles.SUBHEADER_LINK;
import static enums.Users.PITER_CHAILOVSKII;

public class MainPageTestWithPageObjects extends TestBase {

    private WebDriver driver;
    private MainPageSelenium mainPageSelenium;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        mainPageSelenium = PageFactory.initElements(driver, MainPageSelenium.class); }

    @BeforeMethod
    public void beforeMethod() { driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); }

    @AfterMethod
    public  void afterMethod() { driver.close(); }
    @Test
    public void mainPageTest() {



        //1. Open test site by URL
        mainPageSelenium.open(driver);

        //2. Assert  browser title
        mainPageSelenium.checkTitle(driver, HOME_PAGE_TITLE.getTitle());

        //3. Perform login
        mainPageSelenium.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        mainPageSelenium.checkLoginTitle(PITER_CHAILOVSKII.username);

        //5.Assert Browser title
        mainPageSelenium.checkTitle(driver, HOME_PAGE_TITLE.getTitle());

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        mainPageSelenium.checkHeaderItemText();

        //7. Assert that there are 4 images on the Index Page and they are displayed
        mainPageSelenium.checkIcons();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        mainPageSelenium.checkImageTitles();

        //9. Assert a text of the main header
        mainPageSelenium.checkMainHeaderText();

        //10. Assert that there is the frame in the center of page
        mainPageSelenium.checkFrameDisplaying();

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        mainPageSelenium.switchToMainFrame(driver);
        mainPageSelenium.checkFrameLogo(driver);

        //12. Switch to original window back
        mainPageSelenium.switchToParentFrame(driver);

        //13. Assert a text of the sub header
        mainPageSelenium.checkSubHeaderDisplaying();

        //14. Assert that JDI GITHUB is a link and has a proper URL
        mainPageSelenium.checkSubHeaderLink(SUBHEADER_LINK.getTitle());

        //15. Assert that there is Left Section
        mainPageSelenium.checkLeftSectionDisplaying();

        //16. Assert that there is Footer
        mainPageSelenium.checkFooterDisplaying();



    }


}
