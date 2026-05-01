package steps.payment;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.payment.PaymentProductPage;

public class PaymentTest {

    private final WebDriver driver;
    private final PaymentProductPage paymentProductPage;

    public PaymentTest() {
        this.driver = Hooks.getDriver();
        this.paymentProductPage = new PaymentProductPage(driver);
    }

    @When("The user clicks the Proceed to Checkout button")
    public void the_user_clicks_the_proceed_to_checkout_button() {
        paymentProductPage.clickProceedToCheckout();
    }

    @And("The user review the order and place order")
    public void the_user_review_the_order_and_place_order() {
        paymentProductPage.reviewOrderMessage("If you would like to add a comment about your order, please write it in the field below.");
        paymentProductPage.clickPlaceOrder();
    }

    @And("The user enters the information to complete the payment")
    public void the_user_enters_the_information_to_complete_the_payment() {
        paymentProductPage.isTitleEquals();

        paymentProductPage.fillInNameOnCard("Rachel Smith ");
        paymentProductPage.fillInCardNumber(39658484 );
        paymentProductPage.fillInCvc(589);
        paymentProductPage.fillInExpMonth(12);
        paymentProductPage.fillInExpYear(2028);
        paymentProductPage.clickPayConfirmOrder();

    }

    @Then("The {string} message should be displayed")
    public void the_message_should_be_displayed(String expectConfirmMsg) {
        String actualMessage = paymentProductPage.getConfirmMsgPayment();
        Assert.assertEquals(expectConfirmMsg, actualMessage, "The confirm payment message is not displayed");

        System.out.println("Congratulations! Your order has been confirmed!" + actualMessage);

    }

}
