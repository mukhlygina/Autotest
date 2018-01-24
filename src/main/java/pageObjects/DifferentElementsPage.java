package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPage {
    @FindBy(css = "[type = 'checkbox']")
    private ElementsCollection checkbox;

    @FindBy(css = "[name = 'metal']")
    private ElementsCollection metalRadiobuttons;

    @FindBy(css = "[value = 'Button']")
    private SelenideElement button;

    @FindBy(css = "[value = 'Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "div.colors .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection log;

    @FindBy(css = ".panel-body-list.results")
    private ElementsCollection result;

    public void checkNumberOfCheckboxes() {
        checkbox.shouldHaveSize(4);
    }

    public void checkNumberOfRadiobuttons() {
        metalRadiobuttons.shouldHaveSize(4);
    }

    public void selectCheckboxes() {
        checkbox.get(0).click();
        checkbox.get(2).click();
    }

    public void selectRadiobuttons() {
        metalRadiobuttons.get(3).click();
    }

    public void selectDropdown() {
        dropdown.selectOption("Yellow");
    }

    public void checkLogsSection() {

    }

    public void checkButtons() {
        button.should(visible);
        defaultButton.should(visible);
    }

    public void checkDifferentElementsPage() {
        checkNumberOfCheckboxes();
        checkNumberOfRadiobuttons();
        checkButtons();
    }
}
