package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import utils.ConfigReader;
import utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.assertTrue;

public class ProductSteps {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    private static final Logger logger = LogManager.getLogger(ProductSteps.class);

    @Given("I navigate to the homepage")
    public void navigateToHomepage() {
        String baseUrl = ConfigReader.getProperty("base_url");  // ✅ Read from config.properties
        logger.info("Navigating to the homepage: {}", baseUrl);
        driver.get(baseUrl);
    }

    @When("I hover over the {string} menu")
    public void hoverOverMenu(String menu) throws InterruptedException {
        logger.info("Hovering over the menu: {}", menu);
        homePage.hoverOverProductsMenu(menu);
    }

    @Given("Only necessary cookies are accepted")
    public void clickOnlyNecessaryCookies() {
        logger.info("Clicking only necessary cookies");
        homePage.clickOnlyNecessaryCookies();
    }

    @When("I click on the {string} category")
    public void clickOnCategory(String category) {
        logger.info("Clicking on the category: {}", category);
        homePage.clickProductCategory(category);
    }

    @Then("I verify that products are displayed")
    public void verifyProductsDisplayed() {
        logger.info("Verifying that products are displayed");
        assertTrue(productsPage.areProductsDisplayed(), "Products were not found!");
    }

    @Then("I verify each product has a title and description")
    public void verifyProductTitlesAndDescriptions() {
        logger.info("Verifying each product has a title and description");
        assertTrue(productsPage.allProductsHaveTitlesAndDescriptions(), "Products are missing titles or descriptions!");
    }

    @When("I click on Read more for the first product")
    public void clickReadMore() {
        logger.info("Clicking on Read more for the first product");
        productsPage.clickReadMoreOnFirstProduct();
    }

    @Then("I should be redirected to the product details page")
    public void verifyProductDetailsPage() {
        logger.info("Verifying redirection to the product details page");
        assertTrue(productDetailPage.checkAddToQuoteRequest(), "User is not redicted to product details page!");
    }
}
