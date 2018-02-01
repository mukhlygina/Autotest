package pageObjects;

import enums.IndexPageTextEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumIndexPage {

    private WebDriver driver;

    public SeleniumIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo")
    private WebElement profilePhoto;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsBenefit;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> iconsBenefit;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainHeader;

    @FindBy(css = ".main-txt.text-center")
    private WebElement mainText;

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkPageTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkLoggedUserName(String name) {
        Assert.assertEquals(profilePhoto.getText(), name);
    }

    public void checkImages() {
        assertEquals(iconsBenefit.size(), 4);
        for (WebElement icon : iconsBenefit) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkMainHeader(String headerText) {
        assertEquals(mainHeader.getText(), headerText);
    }

    public void checkTextsUnderImages() {
        IndexPageTextEnum[] values = IndexPageTextEnum.values();
        assertEquals(textsBenefit.size(), 4);

        for(int i = 0; i < 4; i++) {
            assertEquals(textsBenefit.get(i).getText().replace("\n", " "), values[i].text);
        }
    }

    public void checkMainText(String text) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), text);
    }
}
