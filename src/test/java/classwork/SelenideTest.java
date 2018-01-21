package classwork;

import base.BaseSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideTest extends BaseSelenide {

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void LoginTest() {
        open("https://jdi-framework.github.io/tests");
        Assert.assertEquals(getWebDriver().getTitle(), "Index Page");

        $(".dropdown.uui-profile-menu").click();
        $(By.id("Login")).sendKeys("epam");
        $(By.id("Password")).sendKeys("1234");
        $(".btn-login").click();

        SelenideElement mainHeader = $(".main-title.text-center");
        mainHeader.should(Condition.visible);
    }

    @Test
    public void LoginTest2() {
        open("https://jdi-framework.github.io/tests");
        Assert.assertEquals(getWebDriver().getTitle(), "Index Page");

        $(".dropdown.uui-profile-menu").click();
        $(By.id("Login")).sendKeys("epam");
        $(By.id("Password")).sendKeys("1234");
        $(".btn-login").click();

        SelenideElement mainHeader = $(".main-title.text-center");
        mainHeader.should(Condition.visible);
    }

    @Test
    public void LoginTest3() {
        open("https://jdi-framework.github.io/tests");
        Assert.assertEquals(getWebDriver().getTitle(), "Index Page");

        $(".dropdown.uui-profile-menu").click();
        $(By.id("Login")).sendKeys("epam");
        $(By.id("Password")).sendKeys("1234");
        $(".btn-login").click();

        SelenideElement mainHeader = $(".main-title.text-center");
        mainHeader.should(Condition.visible);
    }
}
