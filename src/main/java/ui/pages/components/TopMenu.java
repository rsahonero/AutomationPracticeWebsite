package ui.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenu {

    private WebDriver driver;
     //By userAccount = By.xpath("//a[text()=' Logged in as ']");
     @FindBy(xpath = "//a[text()=' Logged in as ']")
     private WebElement userAccount;
    public TopMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String UserAccountLogged(){
       // return driver.findElement(userAccount).getText();
        return userAccount.getText();
//        WebElement textAccount = driver.findElement((String.format(userAccount, text)));
//                return textAccount.isDisplayed();
    }
}
