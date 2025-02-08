package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait
        this.actions = new Actions(driver);
    }

    /** ✅ Generic method to find a web element */
    protected WebElement getElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    /** ✅ Generic method to find multiple elements */
    protected List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /** ✅ Generic method to click an element */
    protected void clickElement(By locator) {
        WebElement element = getElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /** ✅ Generic method to enter text into a field */
    protected void enterText(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /** ✅ Generic method to get text from an element */
    protected String getText(By locator) {
        return getElement(locator).getText().trim();
    }

    /** ✅ Generic method to get texts from multiple elements */
    protected List<String> getTexts(By locator) {
        return getElements(locator).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /** ✅ Generic method to check if an element is displayed */
    protected boolean isElementDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /** ✅ Generic method to hover over an element */
    protected void hoverElement(By locator) {
        WebElement element = getElement(locator);
        actions.moveToElement(element).perform();
    }

    /** ✅ Scroll to an element */
    protected void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /** ✅ Capture a screenshot (to be used in test failure logging) */
    protected void captureScreenshot(String testName) {
        // Implementation for screenshot capture will be added in logging module
    }
}