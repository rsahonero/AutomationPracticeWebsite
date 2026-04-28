package steps.login;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.pages.login.HomePage;
import ui.pages.login.LoginPage;
import utils.ConfigReader;

import static org.testng.AssertJUnit.assertTrue;

public class IndLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public IndLoginTest() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Given("I am on login Page")
    public void iAmOnLoginPage() {
        this.driver.get(ConfigReader.getAppLoginUrl());
        loginPage = new LoginPage(driver);
        //driver.manage().window().maximize();
    }

    @When("I login with the username and password")
    public void iLoginWithTheUsernameAndPassword() {
        loginPage.enterUsername(ConfigReader.getEmail());
        loginPage.enterPassword(ConfigReader.getPassword());
        homePage = loginPage.clickLogin();
    }


    @Then("I should see the {string} of the logged-in user")
    public void iShouldSeeTheOfTheLoggedInUser(String text) {
        String accountText = homePage.userAccountLogged();
        assertTrue(accountText.contains(text));
    }


}
