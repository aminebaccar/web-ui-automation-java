package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", ConfigReader.getProperty("browser")).toLowerCase();
            boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", ConfigReader.getProperty("headless")));

            logger.info("Launching browser: " + browser);
            logger.info("Headless mode: " + isHeadless);

            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) edgeOptions.addArguments("--headless");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) chromeOptions.addArguments("--headless", "--disable-gpu");
                    driver = new ChromeDriver(chromeOptions);
            }

            logger.info("Browser launched successfully.");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Closing the browser.");
            driver.quit();
            driver = null;
        }
    }
}
