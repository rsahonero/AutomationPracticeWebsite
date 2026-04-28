package steps.product;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.cart.CartProductPage;
import ui.pages.product.ProductListPage;
import utils.ConfigReader;

public class RemoveProductTest {
    private WebDriver driver;
    private ProductListPage productListPage;
    private CartProductPage cartProductPage;

    public RemoveProductTest() {
        this.driver = Hooks.getDriver();
        this.productListPage = new ProductListPage(driver);
        this.cartProductPage = new CartProductPage(driver);
    }
    @Given("Add new product")
    public void add_new_product() {
        this.driver.get(ConfigReader.getAppProductUrl());

        productListPage.isProductListDisplayed();
        productListPage.clickAddProductButton();
        productListPage.getSuccessMessage();
    }
    @And("The user is on the Cart page")
    public void the_user_is_on_the_cart_page() {
        cartProductPage.clickOnTheViewCart();

        boolean isTitleDisplayed = cartProductPage.isTitleEquals();
        Assert.assertTrue(isTitleDisplayed, "You aren't on the Cart page");

    }
    @When("Click the X icon to remove the product")
    public void click_the_x_icon_to_remove_the_product() {
        cartProductPage.clickOnCartDeleteIcon();
    }
    @Then("The product is no longer visible on the page")
    public void the_product_is_no_longer_visible_on_the_page() {
        boolean isProductNotVisible = cartProductPage.isProductNotVisible();
        Assert.assertTrue(isProductNotVisible, "The product is still visible");
    }
}
