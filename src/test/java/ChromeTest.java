import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeTest {

    @Test
    public void LoginJDISiteTest() {
        WebDriver driver = new ChromeDriver();
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

        driver.close();
    }
}
