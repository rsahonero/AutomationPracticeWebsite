package ui.pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class PaymentProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/view_cart']/child::u")
    private WebElement viewCartLink;
    @FindBy(xpath = "//i[@class='fa fa-times']")
    private WebElement iconDeleteProduct;


    public PaymentProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isTitleEquals() {
        String title = driver.getTitle();
        assert title != null;
        return title.contains("Automation Exercise - Checkout");
    }
    public void clickViewCartLink() {
//       try{
//           wait.until(ExpectedConditions.elementToBeClickable())
//       } catch (Exception e) {
//           System.out.println("");
//       }
    }




}
