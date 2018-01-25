package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DatesPage {
    @FindBy(css = ".ui-slider-range")
    private SelenideElement sliderRange;

    @FindBy(css = ".ui-slider-handle")
    private SelenideElement leftHandle;

    @FindBy(xpath = "//div[@class = 'uui-slider blue']/a[1]")
    private SelenideElement rightHandle;

    public void changeRange(int leftRange, int rightRange) {
        leftHandle.dragAndDropTo(sliderRange);
    }
}
