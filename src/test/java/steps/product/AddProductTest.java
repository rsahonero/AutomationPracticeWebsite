package steps.product;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.login.LoginPage;
import ui.pages.product.ProductListPage;
import utils.ConfigReader;


public class AddProductTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductListPage productListPage;
    public AddProductTest() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.productListPage = new ProductListPage(driver);
    }

    @Given("The user has logged in successfully")
    public void theUserHasLoggedInSuccessfully() {
        driver.get(ConfigReader.getAppLoginUrl());
        loginPage.enterUsername(ConfigReader.getEmail());
        loginPage.enterPassword(ConfigReader.getPassword());
        loginPage.clickLogin();

    }

    @And("You are on the Product page")
    public void youAreOnTheProductPage() {
        productListPage.clickOntheProductLink();

        boolean isProductListDisplayed = productListPage.isProductListDisplayed();
        Assert.assertTrue(isProductListDisplayed, "The product page did not load");
    }

    @When("click the {string} button")
    public void clickTheButton(String addProductButton) {
        if(addProductButton.equals("Add to cart")){
            Assert.assertTrue(productListPage.isProductListDisplayed(), "Your aren't on the product page");

            productListPage.clickAddProductButton();
            System.out.println("Click on the Add to cart button");
        }
    }

    @Then("A success message should be displayed {string}")
    public void aSuccessMessageShouldBeDisplayed(String expectMessageProduct) {
        String actualMessage = productListPage.getSuccessMessage();
        Assert.assertEquals(expectMessageProduct, actualMessage, "The message is not correct");

        System.out.println("Successfully message" + actualMessage);
    }


}
