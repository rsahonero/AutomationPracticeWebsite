package ui.pages.product;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    ////div[@class='product-overlay']//p[text()='Sleeveless Dress']
    @FindBy(xpath = "//div[@class='product-overlay']")
    private WebElement product;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductBtnLink;
    @FindBy(id = "quantity")
    private WebElement quantityField;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public boolean isTitleEquals() {
        String title = driver.getTitle();
        assert title != null;
        return title.contains("Automation Exercise - Product Details");
    }
    public void scrollWithActions() {
        new Actions(driver)
                .scrollToElement(product)
                .perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean isProductDisplayed() {
        try {
            actions.moveToElement(product).perform();
            wait.until(ExpectedConditions.visibilityOf(product));
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickViewProduct() {
        try {
            wait.until(ExpectedConditions.visibilityOf(viewProductBtnLink));
            wait.until(ExpectedConditions.elementToBeClickable(viewProductBtnLink));
            viewProductBtnLink.click();
            System.out.println("Click on the View Product link");
        } catch (Exception e) {
            System.out.println("Error when cliking on View Product." + e.getMessage());
        }
    }

    public void increasedQuantity(int times) {
        wait.until(ExpectedConditions.visibilityOf(quantityField));
        wait.until(ExpectedConditions.elementToBeClickable(quantityField));
        quantityField.click();

        for (int i = 0; i < times; i ++) {
            quantityField.sendKeys(Keys.ARROW_UP);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getCurrentQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantityField));
        String value = quantityField.getAttribute("value");

        if (value == null || value.isEmpty()) {
            value = quantityField.getText();
        }
        return Integer.parseInt(value.trim());
    }

    public boolean isQuantityIncrease(int expectedIncrease) {
        int finalQuantity = getCurrentQuantity();
        // teniendo en cuenta que quantity empieza en 1
        return finalQuantity == (1 + expectedIncrease);
    }


}
