package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {
    @FindBy(css = ".uui-slider")
    private SelenideElement sliderRange;

    @FindBy(css = ".uui-slider a:nth-child(1)")
    private SelenideElement leftSliderHandle;

    @FindBy(css = ".uui-slider a:last-child")
    private SelenideElement rightSliderHandle;

    public double getSliderRangeStep() {
        double width = sliderRange.getSize().getWidth();
        return width / 100;
    }

    public void changeRange(int leftRange, int rightRange) {
        sliderRange.scrollTo();
        double step = getSliderRangeStep();

        actions().dragAndDropBy(leftSliderHandle, -300, 0).build().perform();
        actions().dragAndDropBy(rightSliderHandle, -300, 0).build().perform();

        actions().dragAndDropBy(rightSliderHandle, (int) (step * rightRange - step/2), 0).build().perform();
        actions().dragAndDropBy(leftSliderHandle, (int) (step * leftRange - step/2), 0).build().perform();

        leftSliderHandle.shouldHave(exactText(String.valueOf(leftRange)));
        rightSliderHandle.shouldHave(exactText(String.valueOf(rightRange)));
    }
}
