package tests;

import utils.Service;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {
    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        Service.getInstance().initDriver();
    }
}
