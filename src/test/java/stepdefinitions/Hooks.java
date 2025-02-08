package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.ScreenshotUtil;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(scenario);
        }
        DriverManager.quitDriver();
    }
}