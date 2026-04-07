package steps;

import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.components.TopMenu;
import utils.ConfigReader;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class IndLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private TopMenu topMenu;
    private HomePage homePage;

    public IndLoginTest() {
        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(driver);
        this.topMenu = new TopMenu(driver);
    }

    @Given("I am on login Page")
    public void iAmOnLoginPage() {
        this.driver.get(ConfigReader.getAppLoginUrl());
        loginPage = new LoginPage(driver);
        //driver.manage().window().maximize();
    }

    @When("I login with the username and password")
    public void iLoginWithTheUsernameAndPassword() {
//        loginPage.enterUsername(userEmail);
//        loginPage.enterPassword(password);
        loginPage.enterUsername(ConfigReader.getEmail());
        loginPage.enterPassword(ConfigReader.getPassword());
        homePage = loginPage.clickLogin();
    }


    @Then("I should see the {string} of the logged-in user")
    public void iShouldSeeTheOfTheLoggedInUser(String text) {
        String accountText = topMenu.UserAccountLogged();
        assertTrue(accountText.contains(text));
    }


}
