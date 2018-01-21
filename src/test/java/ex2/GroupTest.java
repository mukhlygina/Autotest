package ex2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupTest {

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {{1, "first test"}, {2, "second test"}};
    }

    @Test(dataProvider = "dp", groups = ("smoke"))
    public void smokeTest(int i, String s) {
        System.out.println("smoke result = " + i + ", str = " + s);
    }

    @Test(dataProvider = "dp", groups = "regression")
    public void regressionTest(int i, String s) {
        System.out.println("regression result = " + i*2 + ", str = " + s);
    }

    @Test(dataProvider = "dp", groups = {"regression", "smoke"})
    public void smokeAndRegressionTest(int i, String s) {
        System.out.println("new result = " + i*3 + ", new str = " + s);
    }
}