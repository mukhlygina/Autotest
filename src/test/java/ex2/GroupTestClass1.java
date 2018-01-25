package ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupTestClass1 {
    @DataProvider
    public Object[][] dp() {
        return new Object[][] {{1, "first test"}, {2, "second test"}};
    }

    @Test(dataProvider = "dp", groups = {"smoke"})
    public void smokeTest(int i, String s) {
        System.out.println("smoke result = " + i + ", str = " + s);
    }

    @Test(groups = {"smoke"})
    public void siteTitleTest() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        assertEquals(driver.getTitle(), "Index Page");
        driver.close();
    }
}