package classwork;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

/**
 * @author 473601
 */
public abstract class BaseSelenide {

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;

        Configuration.pageLoadStrategy = "normal";
    }
}
