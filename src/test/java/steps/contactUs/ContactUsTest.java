package steps.contactUs;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ui.pages.ContactUsPage;
import utils.ConfigReader;

public class ContactUsTest {

    private WebDriver driver;
    private final ContactUsPage contactUsPage;

    public ContactUsTest() {
        this.driver = Hooks.getDriver();
        this.contactUsPage = new ContactUsPage(driver);
    }
    @When("The user is on Contact us page")
    public void the_user_is_on_contact_us_page() {
        this.driver.get(ConfigReader.getAppUrl());
        contactUsPage.clickContactUsLink();
    }

    @And("Complete the information in Contact us form")
    public void complete_the_information_in_contact_us_form() {
        contactUsPage.isTitleEquals();
        contactUsPage.fillContacUsFom(
                "Ana Smith",
                "ana@test.com",
                "suggestion areas or improvements",
                "We really appreciate your response to our website",
                "C:\\Users\\Rosario\\Documents\\Selenium2025\\WebAutomation\\untitled\\src\\test\\resources\\documents\\AutomationCoolTesters_Java.pptx"
        );
        contactUsPage.clickSubmitBtn();

    }

    @And("Select Ok in the pop up alert")
    public void select_ok_in_the_pop_up_alert() {
        contactUsPage.alertPopUp();
    }

    @Then("The {string} message is displayed")
    public void the_message_is_displayed(String expectMessageContact) {
        String actualMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(expectMessageContact, actualMessage, "The success message of Contact us is not displayed");

        System.out.println("Successfully message" + actualMessage);
    }

}
