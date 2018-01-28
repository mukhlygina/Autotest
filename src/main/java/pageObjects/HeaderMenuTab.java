package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuTab {
    @FindBy(css = "li.dropdown a[href = 'page1.htm']")
    private SelenideElement service;

    @FindBy(css = "ul.dropdown-menu li")
    private ElementsCollection serviceDropdown;

    @FindBy(xpath = "//a[text() = 'Different elements']")
    private SelenideElement differentElements;

    @FindBy(xpath = "//a[text() = 'Dates']")
    private SelenideElement dates;

    public void selectServiceDropdown() {
        service.click();
    }

    public void checkServiceDropdown() {
        serviceDropdown.shouldHaveSize(6);
    }

    public void openDifferentElementsPage() {
        differentElements.click();
    }

    public void openDatesPage() {
        dates.click();
    }

}
