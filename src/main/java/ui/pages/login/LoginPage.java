package ui.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name = "email")
    private WebElement usernameTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private  WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private static WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameTextBox));
        usernameTextBox.sendKeys(username);
    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
        passwordTextBox.sendKeys(password);
    }
    public HomePage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        HomePage homePage = new HomePage(driver);
        return new HomePage(driver);
    }



}
