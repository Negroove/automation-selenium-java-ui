package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(xpath = "//a[normalize-space()='Categorías']") 
    private WebElement btnCategorias;

    public HomePage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
    }

    // Navegar a la sección Ofertas
    public void goToCategory(String categoria, String... subcategoria) {
        // Abrir la sección de Categorías
        click(btnCategorias);

        // Buscar la categoría principal
        waitForElementIsPresent("a", categoria);
        WebElement categoryElement = findElementByText("a", categoria);
        click(categoryElement);

        // Si se especifica una subcategoría, navegar a ella
        if (subcategoria.length > 0) {
            WebElement subcategoryElement = findElementByText("h3", subcategoria[0]);
            scrollToElement(subcategoryElement);
            click(subcategoryElement);

        }
    }
}
