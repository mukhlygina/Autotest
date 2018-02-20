package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class BaseSelenide {

    // COMMENT
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
