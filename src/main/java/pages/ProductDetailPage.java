package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    private By addToQuoteRequest = By.cssSelector(".addtofavourites");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkAddToQuoteRequest() {
        return isElementDisplayed(addToQuoteRequest);
    }
}