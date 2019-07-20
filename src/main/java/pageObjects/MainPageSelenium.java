package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import enums.*;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPageSelenium {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'name']")
    private WebElement login;

    @FindBy(css = "[id = 'password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = "div.profile-photo > span")
    private WebElement loginTitle;

    @FindBy(css = ".m-l8 > li > a")
    private List<WebElement> headerItems;

    @FindBy(css = "div.benefit-icon > span")
    private List<WebElement> icons;

    @FindBy(css = "div.benefit > span")
    private List<WebElement> imageTitles;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainText;

    @FindBy(css = "iframe")
    private WebElement mainFrame;

    @FindBy(css = "h3.text-center > a")
    private WebElement subHeader;

    @FindBy(css = "div.mCustomScrollBox")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //==============================================methods=========================================

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void switchToMainFrame(WebDriver driver) {
        driver.switchTo().frame(mainFrame);
    }

    public void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    //==============================================checks==========================================

    public void checkTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void checkLoginTitle(String title) {
        assertEquals(loginTitle.getText(), title);
    }

    public void checkHeaderItemText() {
        List<String> content = Items.getList();
        assertEquals(headerItems.size(), 4);
        for (WebElement item : headerItems) {
            assertTrue(content.contains(item.getText()));
        }
    }

    public void checkIcons() {
        assertEquals(icons.size(), 4);
        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkImageTitles() {
        assertEquals(imageTitles.size(), 4);
        for (WebElement image : imageTitles) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkMainHeaderText() {
        //check title in main header
        assertTrue(mainTitle.isDisplayed());
        assertEquals(Texts.MAIN_HEADER_TITLE.text, mainTitle.getText());

        //check text in main header
        assertTrue(mainText.isDisplayed());
        assertEquals(Texts.MAIN_HEADER_TEXT.text, mainText.getText());
    }

    public void checkFrameDisplaying() {

        assertTrue(mainFrame.isDisplayed());
    }

    public void checkFrameLogo(WebDriver driver) {
        WebElement frameLogo = driver.findElement(By.cssSelector("div.epam-logo > a > img"));
        assertTrue(frameLogo.isDisplayed());
    }

    public void checkSubHeaderDisplaying() {

        assertTrue(subHeader.isDisplayed());
    }

    public void checkSubHeaderLink(String link) {

        assertEquals(subHeader.getAttribute("href"), link);
    }

    public void checkLeftSectionDisplaying() {

        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterDisplaying() {

        assertTrue(footer.isDisplayed());

    }

}