package ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

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
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        WebElement profileMenu = driver.findElement(By.cssSelector(".dropdown.uui-profile-menu"));
        profileMenu.click();

        WebElement login = driver.findElement(By.id("Login"));
        WebElement password = driver.findElement(By.id("Password"));

        login.sendKeys("epam");
        password.sendKeys("1234");

        WebElement enterButton = driver.findElement(By.cssSelector(".btn-login"));
        enterButton.click();
        WebElement userName = driver.findElement(By.xpath("//div[@class='profile-photo']/span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        WebElement mainHeader = driver.findElement(By.cssSelector(".main-title.text-center"));
        Assert.assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
    }
}
