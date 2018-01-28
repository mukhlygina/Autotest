package ex1;

import enums.IndexPageTextEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChromeTest {
    private WebDriver driver;
    private String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT" +
            " UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI" +
            " UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM" +
            " DOLORE EU FUGIAT NULLA PARIATUR.";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = ("smoke"))
    public void loginJDISiteTest() {
        //Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        driver.findElement(By.cssSelector(".dropdown.uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".btn-login")).click();

        //Assert User name in the left-top side of screen and Browser title
        WebElement userName = driver.findElement(By.xpath("//div[@class='profile-photo']"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Index Page");

        //Assert that there are 4 images on the Home Page
        List<WebElement> iconsBenefit = driver.findElements(By.cssSelector(".icons-benefit"));
        assertEquals(iconsBenefit.size(), 4);
        for (WebElement icon : iconsBenefit) {
            assertTrue(icon.isDisplayed());
        }

        //Assert that there are 4 texts on the Home Page
        List<WebElement> textBenefit = driver.findElements(By.cssSelector(".benefit-txt"));
        IndexPageTextEnum[] values = IndexPageTextEnum.values();
        for(int i = 0; i < values.length; i++) {
            assertEquals(textBenefit.get(i).getText().replace("\n", " "), values[i].text);
        }

        //Assert the main header
        WebElement mainHeader = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");

        //Assert the main text
        WebElement mainTextElement = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertEquals(mainTextElement.getText(), mainText);
    }
}
