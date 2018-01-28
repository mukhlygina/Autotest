package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.IndexPageTextEnum;
import enums.PageTextEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class SelenideIndexPage {
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(xpath = "//div[@class='profile-photo']")
    private SelenideElement profilePhoto;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsBenefit;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection iconsBenefit;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement mainHeader;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement mainText;

    @Step
    public void login(String name, String password) {
        loginFormButton.should(visible);
        loginFormButton.click();

        loginInput.sendKeys(name);
        passordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void checkLoggedUserName(String name) {
        profilePhoto.shouldHave(text(name));
    }

    @Step
    public void checkImages() {
        iconsBenefit.shouldHaveSize(4);
        for (SelenideElement icon : iconsBenefit) {
            icon.should(visible);
        }
    }

    @Step
    public void checkMainHeader(String headerText) {
        mainHeader.shouldHave(text(headerText));
    }

    @Step
    public void checkTextsUnderImages() {
        IndexPageTextEnum[] values = IndexPageTextEnum.values();
        textsBenefit.shouldHaveSize(4);

        for(int i = 0; i < 4; i++) {
            assertEquals(textsBenefit.get(i).getText().replace("\n", " "), values[i].text);
        }
    }

    @Step
    public void checkMainText() {
        mainText.should(visible);
        mainText.shouldHave(text(PageTextEnum.HOME_PAGE.mainText));
    }
}
