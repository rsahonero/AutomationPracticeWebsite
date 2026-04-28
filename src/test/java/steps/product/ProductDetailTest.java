package steps.product;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.product.ProductDetailsPage;
import ui.pages.product.ProductListPage;
import utils.ConfigReader;

public class ProductDetailTest {

    private final WebDriver driver;
    private final ProductDetailsPage productDetailsPage;
    private final ProductListPage productListPage;

    public ProductDetailTest(){
        this.driver = Hooks.getDriver();
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.productListPage = new ProductListPage(driver);
    }
    @Given("The user is on the Product page")
    public void the_user_is_on_the_product_page() {
        this.driver.get(ConfigReader.getAppProductUrl());
        productListPage.isProductListDisplayed();

    }
    @When("The user select View Product link")
    public void the_user_select_view_product_link() {
        productDetailsPage.scrollWithActions();

        boolean isProductDisplayed = productDetailsPage.isProductDisplayed();
        Assert.assertTrue(isProductDisplayed, "The product Blue Top is not displayed");
        productDetailsPage.clickViewProduct();

    }
    @And("Increase the quantity of the product by {int}")
    public void increaseTheQuantityOfTheProductBy(int increaseValue) {
        boolean isTitleDisplayed = productDetailsPage.isTitleEquals();
        Assert.assertTrue(isTitleDisplayed, "You aren't on the Product Detail page");

        productDetailsPage.increasedQuantity(increaseValue);
    }
    @Then("The product quantity is now shown as increased")
    public void the_product_quantity_is_now_shown_as_increased() {
        int expectQuantity = 4;

        int actualQuantity = productDetailsPage.getCurrentQuantity();
        Assert.assertEquals(actualQuantity, expectQuantity, "The product quantity was not updated correctly");

    }

}
