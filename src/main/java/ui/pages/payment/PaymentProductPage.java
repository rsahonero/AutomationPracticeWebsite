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

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement proceedToCheckoutBtn;
    @FindBy(name = "message")
    private WebElement messageTxt;
    @FindBy(xpath = "//h2[text()='Address Details']")
    private WebElement reviewOrderPage;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement placeOrderBtn;
    @FindBy(name = "name_on_card")
    private WebElement nameOnCardField;
    @FindBy(name = "card_number")
    private WebElement cardNumberField;
    @FindBy(name = "cvc")
    private WebElement cvcField;
    @FindBy(name = "expiry_month")
    private WebElement expMonthField;
    @FindBy(name = "expiry_year")
    private WebElement expYearField;
    @FindBy(id = "submit")
    private WebElement payConfimOrderBtn;
    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private WebElement confirmMessagePay;

    public PaymentProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckout() {
       try{
           wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
           proceedToCheckoutBtn.click();
       } catch (Exception e) {
           System.out.println("Error when clicking on checkout button");
       }
    }

    public void reviewOrderMessage(String message) {
        try {
            wait.until(ExpectedConditions.visibilityOf(reviewOrderPage));
            wait.until(ExpectedConditions.visibilityOf(messageTxt));
            messageTxt.sendKeys(message);
        } catch (Exception e) {
            System.out.println("The message field is not visible");
        }
    }
    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        placeOrderBtn.click();
    }
    public boolean isTitleEquals() {
        String title = driver.getTitle();
        assert title != null;
        return title.contains("Automation Exercise - Payment");
    }

    public void fillInNameOnCard(String nameOnCard) {
        wait.until(ExpectedConditions.visibilityOf(nameOnCardField));
        nameOnCardField.sendKeys(nameOnCard);
    }
    public void fillInCardNumber(int cardNumber) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberField));
        cardNumberField.sendKeys(String.valueOf(cardNumber));
    }
    public void fillInCvc(int cvc) {
        wait.until(ExpectedConditions.visibilityOf(cvcField));
        cvcField.sendKeys(String.valueOf(cvc));
    }
    public void fillInExpMonth(int expMonth) {
        wait.until(ExpectedConditions.visibilityOf(expMonthField));
        expMonthField.sendKeys(String.valueOf(expMonth));
    }
    public void fillInExpYear(int expYear) {
        wait.until(ExpectedConditions.visibilityOf(expYearField));
        expYearField.sendKeys(String.valueOf(expYear));
    }
    public void clickPayConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(payConfimOrderBtn));
        payConfimOrderBtn.click();
    }

    public String getConfirmMsgPayment() {
        wait.until(ExpectedConditions.visibilityOf(confirmMessagePay));
        return confirmMessagePay.getText();
    }


}
