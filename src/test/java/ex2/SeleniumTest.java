package ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuit() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("time = " + System.currentTimeMillis());
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if(driver.toString().contains("null")) {  driver.quit(); }
    }

    @Test(groups = ("smoke"))
    public void LoginJDISiteTest() {
        driver.manage().window().maximize();

        //Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        driver.findElement(By.cssSelector(".dropdown.uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".btn-login")).click();

        //Assert User name in the left-top side of screen and Browser title
        WebElement userName = driver.findElement(By.xpath("//div[@class='profile-photo']/span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Index Page");

        //Assert the main header
        WebElement mainHeader = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
    }
}
