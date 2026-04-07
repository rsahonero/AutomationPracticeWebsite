package ui.pages;

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

    //private By usernameTextBox = By.xpath("//input[@data-qa='login-email']");
    //private By passwordTextBox = By.xpath("//input[@data-qa='login-password']");
    //private By loginButton = By.xpath("//button[@data-qa='login-button']");

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
        usernameTextBox.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordTextBox.sendKeys(password);
    }
    public HomePage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        HomePage homePage = new HomePage(driver);
        //homePage.waitForPageToLoad();
        return new HomePage(driver);
    }

//    public String getErrorMessage() {
//        try {
//            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated((By) errorMessage));
//            return message.getText();
//        } catch (Exception e) {
//            return "Your email or password is incorrect!";
//        }
//    }


}
