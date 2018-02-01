package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkbox;

    @FindBy(css = ".label-radio")
    private ElementsCollection metalRadiobuttons;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = "[value = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "div.colors .uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection log;

    @FindBy(css = ".panel-body-list.results")
    private ElementsCollection result;

    public void checkNumberOfCheckboxes(int checkboxNumber) {
        checkbox.shouldHaveSize(checkboxNumber);
    }

    public void checkNumberOfRadiobuttons(int radiobtnNumber) {
        metalRadiobuttons.shouldHaveSize(radiobtnNumber);
    }

    public void checkButtons() {
        button.should(visible);
        defaultButton.should(visible);
    }

    public void selectCheckboxes(String element) {
        checkbox.stream().filter(item -> item.getText().equals(element))
                .forEach(item -> item.click());
    }

    public void selectRadiobuttons(String metal) {
        metalRadiobuttons.stream().filter(item -> item.getText().equals(metal))
                .forEach(item -> item.click());
    }

    public void selectDropdown(String option) {
        colorsDropdown.selectOption(option);
    }

    public void checkLogsSection(String name, String condition) {
        String regex = String.format(".* %s: .* %s", name, condition);
        assertTrue(log.stream().anyMatch(row -> row.getText().matches(regex)));
    }

    public void checkDifferentElementsPage(int checkboxNumber, int radiobtnNumber) {
        checkNumberOfCheckboxes(checkboxNumber);
        checkNumberOfRadiobuttons(radiobtnNumber);
        checkButtons();
    }
}
