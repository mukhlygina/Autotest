package ex4;

import com.codeborne.selenide.Configuration;
import enums.*;
import listeners.AllureAttachmentListener;
import org.testng.annotations.*;
import pageObjects.DatesPage;
import pageObjects.DifferentElementsPage;
import pageObjects.HeaderMenuTab;
import pageObjects.SelenideIndexPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})
public class SelenidePageObjectsTest {
    private SelenideIndexPage indexPage;
    private HeaderMenuTab menu;
    private DifferentElementsPage differentElementsPage;
    private DatesPage datesPage;

    @BeforeSuite
    public void beforeSuit() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
    }

    @BeforeMethod
    public void setUpPages() {
        indexPage = page(SelenideIndexPage.class);
        menu = page(HeaderMenuTab.class);
        differentElementsPage = page(DifferentElementsPage.class);
        datesPage = page(DatesPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void differentElementsPageTest() {
        //1 Perform login
        indexPage.openIndexPage();
        indexPage.login(UserEnum.PITER_CHAILOVSKII.login, UserEnum.PITER_CHAILOVSKII.password);

        //2 Assert User name in the left-top side of screen
        indexPage.checkLoggedUserName(UserEnum.PITER_CHAILOVSKII.name);

        //3 Assert that there are 4 images on the Home Page
        indexPage.checkImages();

        //4 Assert that there are 4 texts on the Home Page
        indexPage.checkTextsUnderImages();

        //5 Assert the main header
        indexPage.checkMainHeader(PageTextEnum.HOME_PAGE.mainHeader);

        //6 Assert the main text
        indexPage.checkMainText();

        //7 Click on "Service" subcategory in the header and check that drop down contains options
        menu.selectServiceDropdown();
        menu.checkServiceDropdown();

        //8 Open through the header menu Service -> Different Elements Page
        menu.openDifferentElementsPage();

        //9 Check interface on Service page, it contains all needed elements
        differentElementsPage.checkDifferentElementsPage();

        //10 Select and assert checkboxes
        differentElementsPage.selectCheckbox(ElementsCheckboxEnum.Water);
        differentElementsPage.selectCheckbox(ElementsCheckboxEnum.Wind);

        //11 Select radio
        differentElementsPage.selectRadiobutton(MetalEnum.Selen);

        //12 Select in dropdown
        differentElementsPage.selectDropdown(ColorEnum.Yellow);

        //13 Check in logs section selected values and status
        differentElementsPage.checkLogsSection(ElementsCheckboxEnum.Water.toString(), true);
        differentElementsPage.checkLogsSection(ElementsCheckboxEnum.Wind.toString(), true);
        differentElementsPage.checkLogsSection("metal", MetalEnum.Selen.toString());
        differentElementsPage.checkLogsSection("Colors", ColorEnum.Yellow.toString());

        //14 Unselect checkboxes
        differentElementsPage.selectCheckbox(ElementsCheckboxEnum.Water);
        differentElementsPage.selectCheckbox(ElementsCheckboxEnum.Wind);

        //15 Check in logs section unselected values and status (true|false)
        differentElementsPage.checkLogsSection(ElementsCheckboxEnum.Water.toString(), false);
        differentElementsPage.checkLogsSection(ElementsCheckboxEnum.Wind.toString(), false);
    }

    @Test
    public void datesPageTest() {
        //1 Perform login
        indexPage.openIndexPage();
        indexPage.login(UserEnum.PITER_CHAILOVSKII.login, UserEnum.PITER_CHAILOVSKII.password);

        //2 Assert User name in the left-top side of screen
        indexPage.checkLoggedUserName(UserEnum.PITER_CHAILOVSKII.name);

        //3 Open Service -> Dates
        menu.selectServiceDropdown();
        menu.openDatesPage();

        //4 Using drag-and-drop set Range sliders MAX range
        datesPage.changeRange(0, 100);

        //5  Using drag-and-drop set Range sliders MIN range
        datesPage.changeRange(0, 0);

        //6  Using drag-and-drop set Range sliders MIN range
        datesPage.changeRange(100, 100);

        //7  Using drag-and-drop set Range sliders range (30, 70)
        datesPage.changeRange(30, 70);
    }
}
