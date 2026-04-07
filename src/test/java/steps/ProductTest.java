package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.LoginPage;
import ui.pages.components.ProductsPage;
import utils.ConfigReader;

import java.time.Duration;


public class ProductTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    public ProductTest() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
    }

    @Given("The user has logged in successfully")
    public void theUserHasLoggedInSuccessfully() {
        driver.get(ConfigReader.getAppLoginUrl());
        loginPage.enterUsername(ConfigReader.getEmail());
        //String email = ConfigReader.getEmail();
        loginPage.enterPassword(ConfigReader.getPassword());
        loginPage.clickLogin();

    }

    @And("You are on the Product page")
    public void youAreOnTheProductPage() {
        productsPage.clickOntheProductLink();

        boolean isProductListDisplayed = productsPage.isProductListDisplayed();
        Assert.assertTrue(isProductListDisplayed, "The product page did not load");
    }

    @When("click the {string} button")
    public void clickTheButton(String addProductButton) {
        if(addProductButton.equals("Add to cart")){
            Assert.assertTrue(productsPage.isProductListDisplayed(), "Your aren't on the product page");

            productsPage.clickAddProductButton();
            System.out.println("Click on the Add to cart button");
        }
    }

    @Then("A success message should be displayed {string}")
    public void aSuccessMessageShouldBeDisplayed(String expectMessageProduct) {
        String actualMessage = productsPage.getSuccessMessage();
        Assert.assertEquals(expectMessageProduct, actualMessage, "The message is not correct");

        System.out.println("Successfully message" + actualMessage);
    }

    //
}
