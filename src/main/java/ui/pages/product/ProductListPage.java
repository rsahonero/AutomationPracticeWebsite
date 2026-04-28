package ui.pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private Actions actions;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productLink;
    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement productList;

    //div[@class='continue-prompt-text']
    //div[@class='continue-prompt-text']
    @FindBy(xpath = "//div[@class='continue-prompt-text']")
    private  WebElement popUpError;
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    private WebElement addToCart;
    @FindBy(xpath = "//p[text()='Your product has been added to cart.']")
    private WebElement successMessage;

    //Ver la lista de productos seleccionado
    @FindBy(xpath = "//a[@href='/view_cart']//child::u")
    private WebElement viewCart;

    @FindBy(xpath = "//a[text()='Blue Top']")
    private WebElement selectProduct;
    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //Metodo para verificar que estamos en la pagina de producto
    public void clickOntheProductLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productLink));
            productLink.click();
            System.out.println("Click on the product link");
        } catch (Exception e) {
            System.out.println("Error when clicking on Products." + e.getMessage());
        }
//        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
//        addToCart.click();

    }

    public boolean isProductListDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productList));
            return  productList.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //Click on "Add to cart"
    public  void clickAddProductButton() {
        actions.moveToElement(addToCart).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
    }

    //Metodo para obtener el mensaje exitoso
    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    public boolean isTitleEquals(String expectedTitle) {
        String title = driver.getTitle();
        assert title != null;
        boolean equals = title.equals(expectedTitle);
        System.out.println("The title is" + expectedTitle + equals);
        return equals;
    }



}
