package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceMenuEnum;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

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

        List<String> menuTitles = serviceDropdown.stream()
                .map(item -> item.getText().toLowerCase()).collect(Collectors.toList());

        Arrays.asList(ServiceMenuEnum.values()).stream()
                .forEach(enumItem -> assertTrue(menuTitles.contains(enumItem.text.toLowerCase())));
    }

    public void openDifferentElementsPage() {
        differentElements.click();
    }

    public void openDatesPage() {
        dates.click();
    }

}
