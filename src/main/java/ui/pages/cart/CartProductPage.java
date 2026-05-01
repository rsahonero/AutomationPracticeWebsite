package ui.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartProductPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //Ver la lista de productos seleccionado
    @FindBy(xpath = "//a[@href='/view_cart']//child::u")
    private WebElement viewCart; // link que se muestra en el mensaje de success despues de seleccionar un producto
    @FindBy(xpath = "//a[@href='/view_cart']/child::i")
    private  WebElement cartMenuLink;
    @FindBy(xpath = "//a[text()='Blue Top']")
    private WebElement selectProduct;
    @FindBy(xpath = "//i[@class='fa fa-times']")
    private WebElement cartDeleteIcon;
    public CartProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheViewCart() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(viewCart));
            viewCart.click();
            System.out.println("Click on the Cart link");
        } catch (Exception e) {
            System.out.println("Error when clicking on Cart." + e.getMessage());
        }
    }
    public boolean isTitleEquals() {
        String title = driver.getTitle();
        assert title != null;
        return title.contains("Automation Exercise - Checkout");
    }

    public void clickOnCartDeleteIcon() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cartDeleteIcon));
            cartDeleteIcon.click();
        } catch (Exception e) {
            System.out.println("Error when cliking on Cart delete icon." + e.getMessage());
        }
    }

    public boolean isProductNotVisible() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(selectProduct));
            System.out.println("Verificacion exitosa: El producto ha sido eliminado");
            return true;
        } catch (Exception e) {
            System.out.println("El producto no ha sido eliminado aun es visible");
            return false;
        }
    }



}
