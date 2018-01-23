package ex4;

import com.codeborne.selenide.Configuration;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.SelenideIndexPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})

public class SelenidePageObjectsTest {
    private SelenideIndexPage indexPage;

    @BeforeClass
    public void setUpPages() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;

        indexPage = open("https://jdi-framework.github.io/tests", SelenideIndexPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void loginTest() {
        //Perform login
        indexPage.login("epam", "1234");

        //Assert User name in the left-top side of screen
        indexPage.checkLoggedUserName("PITER CHAILOVSKII");

        //Assert that there are 4 images on the Home Page
        indexPage.checkImages();

        //Assert that there are 4 texts on the Home Page
        indexPage.checkTextsUnderImages();

        //Assert the main header
        indexPage.checkMainHeader("EPAM FRAMEWORK WISHES…");

        //Assert the main text
        indexPage.checkMainText();
    }
}
