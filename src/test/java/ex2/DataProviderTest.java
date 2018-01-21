package ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataProviderTest extends BaseTest {

    @DataProvider(parallel = true)
    public Object[][] dataProvider() {
        return new Object[][] {{0, "To include good practices and ideas from successful EPAM projec"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}};
    }


    @Test(dataProvider = "dataProvider", groups = ("smoke"))
    public void LoginJDISiteTest(int index, String text) {
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        List<WebElement> textBenefit = driver.findElements(By.cssSelector(".benefit-txt"));

        assertEquals(textBenefit.get(index).getText().replace("\n", " "), text);
    }

}
