package ex4;

import com.codeborne.selenide.Configuration;
import listeners.AllureAttachmentListener;
import org.testng.annotations.*;
import pageObjects.DatesPage;
import pageObjects.DifferentElementsPage;
import pageObjects.HeaderMenuTab;
import pageObjects.SelenideIndexPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})

public class SelenidePageObjectsTest {
    private SelenideIndexPage indexPage;

    @BeforeMethod
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
    public void differentElementsPageTest() {
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

        //Click on "Service" subcategory in the header and check that drop down contains options
        HeaderMenuTab menu = page(HeaderMenuTab.class);
        menu.selectService();
        menu.checkServiceDropdown();

        //Open through the header menu Service -> Different Elements Page
        menu.openDifferentElementsPage();

        //Check interface on Service page, it contains all needed elements
        DifferentElementsPage differentElementsPage = page(DifferentElementsPage.class);
        differentElementsPage.checkDifferentElementsPage();

        //Select and assert checkboxes
        differentElementsPage.selectCheckboxes();

        //Select radio
        differentElementsPage.selectRadiobuttons();

        //Select in dropdown
        differentElementsPage.selectDropdown();

        //Check in logs section selected values and status
        differentElementsPage.checkLogsSection();
        differentElementsPage.selectCheckboxes();
    }

    @Test
    public void datesPageTest() {
        //Perform login
        indexPage.login("epam", "1234");

        //Assert User name in the left-top side of screen
        indexPage.checkLoggedUserName("PITER CHAILOVSKII");

        //Open Service -> Dates
        HeaderMenuTab menu = page(HeaderMenuTab.class);
        menu.selectService();
        menu.openDatesPage();

        DatesPage datesPage = page(DatesPage.class);
        datesPage.changeRange(0, 100);
    }
}
