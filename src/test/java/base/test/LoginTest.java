package base.test;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConfigReader;


import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @Test
    public void testLoginSuccessfully(){
        driver.get(ConfigReader.getAppUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("testRosi.Automation@gmail.com");
        loginPage.enterPassword("Password@123");
        HomePage homePage = loginPage.clickLogin();

    }
}
