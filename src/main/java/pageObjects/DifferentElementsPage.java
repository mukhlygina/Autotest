package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage {
    @FindBy(css = "[type = 'checkbox']")
    private ElementsCollection checkbox;

    @FindBy(css = "[type='radio']")
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

    public void selectCheckboxes(String element) {
        checkbox.stream().filter(item -> item.getText().equals(element))
                .forEach(item -> item.click());
    }

    public void selectRadiobuttons(String metal) {
        metalRadiobuttons.stream().filter(elem -> elem.getText()
                .equals(metal))
                .forEach(elem -> elem.click());
    }

    public void selectDropdown(String option) {
        colorsDropdown.selectOption(option);
    }

    public void checkLogsSection() {

    }

    public void checkButtons() {
        button.should(visible);
        defaultButton.should(visible);
    }

    public void checkDifferentElementsPage(int checkboxNumber, int radiobtnNumber) {
        checkNumberOfCheckboxes(checkboxNumber);
        checkNumberOfRadiobuttons(radiobtnNumber);
        checkButtons();
    }
}
