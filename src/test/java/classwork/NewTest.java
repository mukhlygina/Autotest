package classwork;

import ex1.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest  extends BaseTest {

//    private WebDriver driver;

    @Test
    public void LoginJDISiteTest() {
        BaseTest.driver.manage().window().maximize();
        BaseTest.driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(BaseTest.driver.getTitle(), "Index Page");

        WebElement profileMenu = BaseTest.driver.findElement(By.cssSelector(".dropdown.uui-profile-menu"));
        profileMenu.click();

        WebElement login = BaseTest.driver.findElement(By.id("Login"));
        WebElement password = BaseTest.driver.findElement(By.id("Password"));

        login.sendKeys("epam");
        password.sendKeys("1234");

        WebElement enterButton = BaseTest.driver.findElement(By.cssSelector(".btn-login"));
        enterButton.click();
        WebElement userName = BaseTest.driver.findElement(By.xpath("//div[@class='profile-photo']/span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        WebElement mainHeader = BaseTest.driver.findElement(By.cssSelector(".main-title.text-center"));
        Assert.assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
    }
}
