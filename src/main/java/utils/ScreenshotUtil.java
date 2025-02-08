package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.DriverManager.driver;

public class ScreenshotUtil {

    public static void captureScreenshot(Scenario scenario) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/screenshots/" + scenario.getName().replace(" ", "_") + ".png";
            Files.createDirectories(Paths.get("target/screenshots/"));  // Ensure directory exists
            Path target = Paths.get(screenshotPath);
            Files.copy(screenshot.toPath(), target);

            // Attach screenshot to Cucumber report
            scenario.attach(Files.readAllBytes(target), "image/png", scenario.getName());
        } catch (IOException e) {
            System.err.println("❌ Screenshot capture failed: " + e.getMessage());
        }
    }
}