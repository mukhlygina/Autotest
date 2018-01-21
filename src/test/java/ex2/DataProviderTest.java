package ex2;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderTest extends BaseTest {

    @DataProvider(parallel = true)
    public Object[][] dataProvider() {
        return new Object[][] {{"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable", "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"}};
    }


    @Test(dataProvider = "dataProvider", groups = ("smoke"))
    public void LoginJDISiteTest(String text, String text1, String text2, String text3) {
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        List<WebElement> textBenefit = driver.findElements(By.cssSelector(".benefit-txt"));

        Assert.assertEquals(textBenefit.get(0).getText().replace("\n", " "), text);
        Assert.assertEquals(textBenefit.get(1).getText().replace("\n", " "), text1);
        Assert.assertEquals(textBenefit.get(2).getText().replace("\n", " "), text2);
        Assert.assertEquals(textBenefit.get(3).getText().replace("\n", " "), text3);
    }

}
