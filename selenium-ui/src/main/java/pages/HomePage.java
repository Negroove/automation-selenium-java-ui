package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    // Botones menu principal 

    @FindBy(xpath = "//a[normalize-space()='Ofertas']")
    private WebElement btnOfertas;

    @FindBy(xpath = "//a[normalize-space()='Cupones']")
    private WebElement btnCupones;

    @FindBy(xpath = "//a[@class='nav-menu-item-link'][normalize-space()='Supermercado']")
    private WebElement btnSupermercado;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // navegar a ofertas 
    public void goToOffers() {
        click(btnOfertas);
    }

    // navegar a cupones
    public void goToCoupons() {
        click(btnCupones);
    }

    // navegar a supermercado
    public void goToSupermarket() {
        click(btnSupermercado);
    }
}
