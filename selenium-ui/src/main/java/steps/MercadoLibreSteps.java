package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.CategoryPage;
import pages.HomePage;

public class MercadoLibreSteps extends BasePage {

    private CategoryPage categoryPage;
    private HomePage homePage;

    // Constructor
    public MercadoLibreSteps(WebDriver driver) {
        super(driver);
        this.categoryPage = new CategoryPage(driver); 
        this.homePage = new HomePage(driver);   
    }

    @Step("Navegar a la categoría {categoria} -> {subcategoria}")
    public void navegarACategoria(String... categorias) {
        categoryPage.navigateToCategory(categorias);
    }

    @Step("Seleccionar subcategoría {subcategoria}")
    public void seleccionarCategoriaSecundaria(String elemento,String subcategoria) {
        categoryPage.anotherCategory(elemento, subcategoria);
    }

    @Step("Validar filtros para {filtros}")
    public void validarFiltros(String... filtros) {
        categoryPage.validateFilters(filtros);
    }

    @Step("Validar que el título de la categoría {elemento} sea {texto}")
    public void validarTituloDeCategoria(String elemento, String texto) {
        categoryPage.validateCategoryTitle(elemento, texto);
    }

    @Step("Navegar al supermercado desde el menú")
    public void navegarAlSupermercado() {
        homePage.goToSupermarket();
    }

    @Step("Navegar a ofertas del día")
    public void navegarAOfertasDelDia() {
        homePage.goToOffers();
    }

    @Step("Navegar a la sección de Moda")
    public void navegarAModa() {
        homePage.goToModa();
    }

    @Step("Aplicar filtro de precio de {min} a {max} y validar resultados")
    public void aplicarFiltroDePrecioYValidarResultados(String min, String max) {
        String initialTotal = categoryPage.getTotalResults();
        categoryPage.applyPriceRangeFilter(min, max);
        categoryPage.validateResultsUpdated(initialTotal);
    }

    @Step("Validar que los resultados no sean nulos")
    public void validarResultadosNoNulos() {
        categoryPage.checkValidateResults();
    }
}
