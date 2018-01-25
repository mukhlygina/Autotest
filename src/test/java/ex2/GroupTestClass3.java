package ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupTestClass3 {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] {{2, "first test"}, {4, "second test"}};
    }

    @Test(dataProvider = "dp", groups = {"regression", "smoke"})
    public void smokeAndRegressionTest(int i, String s) {
        System.out.println("new result = " + i*3 + ", new str = " + s);
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleSiteTest() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        WebElement mainHeader = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertEquals(mainHeader.getText(), "EPAM FRAMEWORK WISHES…");
        driver.close();
    }
}
