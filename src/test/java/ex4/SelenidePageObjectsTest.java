package ex4;

import com.codeborne.selenide.Configuration;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.WebDriver;
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
    private WebDriver driver;
    private SelenideIndexPage indexPage;

    @BeforeClass
    public void setUpPages() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
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
    }
}
