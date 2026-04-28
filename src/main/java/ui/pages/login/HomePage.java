package ui.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.text;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    private WebElement userAccount;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public  String userAccountLogged() {
        return userAccount.getText();
    }
}
