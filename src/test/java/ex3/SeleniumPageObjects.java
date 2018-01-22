package ex3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SeleniumIndexPage;

public class SeleniumPageObjects {
    private WebDriver driver;
    SeleniumIndexPage indexPage;

    @BeforeClass
    public void setUpPages() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        indexPage = PageFactory.initElements(driver, SeleniumIndexPage.class);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTest() {
        //Open test site
        indexPage.open(driver);
        //Perform login
        indexPage.login("epam", "1234");

        //Assert User name in the left-top side of screen and Browser title
        indexPage.checkLoggedUserName("PITER CHAILOVSKII");
        indexPage.checkPageTitle(driver);

        //Assert that there are 4 images on the Home Page
        indexPage.checkIcons();

        //Assert that there are 4 texts on the Home Page
        indexPage.checkTextsUnderImages();

        //Assert the main header
        indexPage.checkMainHeader("EPAM FRAMEWORK WISHES…");

        //Assert the main text
        indexPage.checkMainText();
    }
}
