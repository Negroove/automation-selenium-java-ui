package tests;

import base.BaseTest;
import pages.CategoryPage;
import pages.HomePage;

import org.testng.annotations.Test;

public class MercadoLibreTest extends BaseTest {

    @Test(groups = { "regresion" })
    public void validarCategoriaConstruccion() {
        CategoryPage categoryPage = new CategoryPage(driver);

        // 1. Navegar a la categoria
        categoryPage.navigateToCategory("Construcción", "Baños y Sanitarios");

        // 2. Navegar a la 3ra categoria
        categoryPage.anotherCategory("span", "Grifería para Baño");

        // 3. Validar filtros
        categoryPage.validateFilters("Construcción", "Baños y Sanitarios");

        // 4. Validar titulo de la categoria
        categoryPage.validateCategoryTitle("h2", "Grifería para Baño");
    }

    @Test(groups = { "regresion" })
    public void validarCategoriaSupermercado() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // 1. Navegar al supermercado desde el menu
        homePage.goToSupermarket();

        // 2. Seleccionar subcategoria
        categoryPage.anotherCategory("span", "CAPSULAS");

        // 3. Validar filtros
        categoryPage.validateFilters("Alimentos y Bebidas", "Almacén", "Infusiones");

        // 4. Validar titulo de la categoria
        categoryPage.validateCategoryTitle("h1", "Cápsulas en Supermercado");
    }

    @Test(groups = { "regresion" })
    public void validarCategoriaOfertaDelDia() {
        
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        // 1. Navegar a ofertas del día
        homePage.goToOffers();

        categoryPage.anotherCategory("a", "Oferta del día");

        // 3. Validar título de la categoria
        categoryPage.validateCategoryTitle("h1", "Todas");
    }

    @Test(groups = { "integracion" })
    public void validarCategoriaTecnologia() {
        CategoryPage categoryPage = new CategoryPage(driver);

        // 1. Navegar a tecnologia
        categoryPage.navigateToCategory("Tecnología");

        // 2 . Accesorios para celulares
        categoryPage.anotherCategory("a", "Accesorios para Celulares");

        // 3. Validar titulo de la categoria
        categoryPage.validateCategoryTitle("span", "Celulares y Teléfonos");
        categoryPage.validateCategoryTitle("h2", "Accesorios para Celulares");
    }

    @Test(groups = { "integracion" })
    public void validarCategoriaSupermercadoFiltrosPrecio() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        homePage.goToSupermarket();

        categoryPage.anotherCategory("span", "SALUDABLES");

        // Extraer total inicial de resultados
        String initialTotal = categoryPage.getTotalResults();
        System.out.println("Resultados iniciales: " + initialTotal);

        // Aplicar el filtro de rango de precios
        categoryPage.applyPriceRangeFilter("10000", "15000");

        // Validar que los resultados se hayan actualizado
        categoryPage.validateResultsUpdated(initialTotal);
    }

    @Test(groups = { "integracion" })
    public void validarCategoriaModaOfertasFiltrosPrecio() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        homePage.goToModa();

        categoryPage.anotherCategory("span", "OFERTAS DEL DÍA");

        // Extraer total inicial de resultados
        String initialTotal = categoryPage.getTotalResults();
        System.out.println("Resultados iniciales: " + initialTotal);

        // Aplicar el filtro de rango de precios
        categoryPage.applyPriceRangeFilter("10000", "15000");

        // Validar que los resultados se hayan actualizado
        categoryPage.validateResultsUpdated(initialTotal);
    }


}
