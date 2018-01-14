package classwork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {{1, "some"}, {2, "another"}};
    }

    @Test(dataProvider = "dp", groups = ("smoke"))
    public void someTest(int i, String s) {
        System.out.println("num = " + i + "str = " + s);
    }
}

