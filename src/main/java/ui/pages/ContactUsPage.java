package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/contact_us']")
    private WebElement contactUsBtn;
    @FindBy(name = "name")
    private WebElement nameField;
    @FindBy(name = "email")
    private WebElement emailField;
    @FindBy(name = "subject")
    private WebElement subjectField;
    @FindBy(id = "message")
    private WebElement msgField;
    @FindBy(name = "upload_file")
    private WebElement uploadDocument;
    @FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[text()='Success! Your details have been submitted successfully.']")
    private WebElement successContactUs;


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public boolean isTitleEquals() {
        String title = driver.getTitle();
        assert title != null;
        return title.contains("Automation Exercise - Contact Us");
    }
    public void clickContactUsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsBtn));
        contactUsBtn.click();
    }
    public void fillInName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
    }
    public void fillInEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }
    public void fillInSubject(String subject) {
        wait.until(ExpectedConditions.visibilityOf(subjectField));
        subjectField.sendKeys(subject);
    }
    public void fillInMessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(msgField));
        msgField.sendKeys(message);
    }
    public void attachDocument(String fileAbsolutePath) {
        wait.until(ExpectedConditions.visibilityOf(uploadDocument));
        uploadDocument.sendKeys(fileAbsolutePath);

    }
    public void clickSubmitBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }
    public void fillContacUsFom(String name, String email, String subject, String message, String filePath) {
        fillInName(name);
        fillInEmail(email);
        fillInSubject(subject);
        fillInMessage(message);
        attachDocument(filePath);
    }
    public void alertPopUp() {
        driver.switchTo().alert().accept();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successContactUs));
        return successContactUs.getText();
    }

}
