package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    private By productsMenu = By.xpath("//a[@name='Products']");
    private By onlyNecessaryCookiesButton = By.xpath("//a[contains(text(),'Only necessary cookies')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverProductsMenu(String menu) throws InterruptedException {
        Thread.sleep(1000);
        if (menu.equals("Products")){
            hoverElement(productsMenu);
        }
        else {
            hoverElement(By.xpath("//a[@name='" + menu + "']"));
        }
    }

    public void clickOnlyNecessaryCookies() {
        clickElement(onlyNecessaryCookiesButton);
    }

    public void clickProductCategory(String categoryName) {
        clickElement(By.xpath("//a[@title='" + categoryName + "']"));
    }
}
