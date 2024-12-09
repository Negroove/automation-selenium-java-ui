package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CategoryPage extends BasePage {

    // Elementos Web
    @FindBy(xpath = "//*[@id=\"hub\"]/div[2]/section/section/div/a")
    private WebElement btnSeeAll;

    @FindBy(xpath = "//a[normalize-space()='Categorías']")
    private WebElement btnCategorias;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    private WebElement lblResults;

    @FindBy(xpath = "//input[@data-testid='Minimum-price']")
    private WebElement txtiMinimoPrecio;

    @FindBy(xpath = "//input[@data-testid='Maximum-price']")
    private WebElement txtiMaximoPrecio;

    // Constructor
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void anotherCategory(String tag, String text) {
        WebElement terceraCategoria = findElementByText(tag, text);
        click(terceraCategoria);
    }

    // region Métodos para Navegación de categoria, es imporante no equivocarse enel
    // orden cuando se ingresan
    public void navigateToCategory(String... categories) {
        // Comienza desde el botón de "Categorías"
        click(btnCategorias);

        // navega por cada nivel de categoria
        for (int i = 0; i < categories.length; i++) {
            String tag = (i == 0) ? "a" : "h3"; // categoria principal <a>, subcategoria <h3>
            WebElement categoryElement = findElementByText(tag, categories[i]);
            scrollToElement(categoryElement);
            click(categoryElement);
        }
    }

    // obtener texto por etiqueta y texto
    public String getTextByElement(String tag, String expectedText) {
        WebElement element = findElementByText(tag, expectedText);
        return element.getText();
    }

    public void applyPriceRangeFilter(String minPrice, String maxPrice) {
        scrollToElement(txtiMinimoPrecio);

        type(txtiMinimoPrecio, minPrice);

        scrollToElement(txtiMaximoPrecio);

        type(txtiMaximoPrecio, maxPrice);

        txtiMaximoPrecio.sendKeys(Keys.ENTER);

        waitForPageToLoad();
    }

    // region Validaciones
    // Validar que el total de resultados se actualice después de aplicar filtros
    public void validateResultsUpdated(String initialTotal) {
        waitForPageToLoad();
        String updatedTotal = getTotalResults();
        if (initialTotal.equals(updatedTotal)) {
            throw new AssertionError("EL TOTAL DE LOS RESULTADO NO CAMBIO");
        }
        System.out.println("RESULTADOS ACTUALIZADOS:  " + updatedTotal);
    }

    // valida el texto de un elemento
    public void validateTextByElement(String tag, String expectedText) {
        String actualText = getTextByElement(tag, expectedText);
        Assert.assertEquals(actualText, expectedText, "EL TEXTO NO COINCIDE");
    }

    // valida filtros de la pagina
    public void validateFilters(String... filters) {
        for (String filter : filters) {
            validateTextByElement("span", filter);
        }
    }

    // valida el titulo de la categoria
    public void validateCategoryTitle(String tag, String expectedTitle) {
        validateTextByElement(tag, expectedTitle);
    }

    // valida que el total de los resultados no sea nulo
    public void checkValidateResults() {
        String totalResults = getTotalResults();
        System.out.println("TOTAL DE RESULTADOS: " + totalResults);
        Assert.assertNotNull(totalResults, "EL TOTAL DE LOS RESULTADOS NO DEBE VENIR NULO");
    }

    // obtiene el total de los resultados
    public String getTotalResults() {
        System.out.println("LOS RESULTADOS SON: " + lblResults.getText());
        waitForElementToBeReady(lblResults);
        return lblResults.getText();
    }
    // endregion

}
