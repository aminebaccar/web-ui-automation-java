package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class ProductsPage extends BasePage {
    private By productList = By.cssSelector(".shop_productlistcolumn_item");
    private By productTitle = By.cssSelector(".details .name");
    private By productDescription = By.cssSelector(".details .teaser");
    private By readMoreButton = By.xpath("//a[@class='viewproduct']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean areProductsDisplayed() {
        return !getElements(productList).isEmpty();
    }

    public boolean allProductsHaveTitlesAndDescriptions() {
        List<String> titles = getTexts(productTitle);
        List<String> descriptions = getTexts(productDescription);
        return titles.stream().allMatch(title -> !title.isEmpty()) && descriptions.stream().allMatch(desc -> !desc.isEmpty());
    }

    public void clickReadMoreOnFirstProduct() {
        clickElement(readMoreButton);
    }
}