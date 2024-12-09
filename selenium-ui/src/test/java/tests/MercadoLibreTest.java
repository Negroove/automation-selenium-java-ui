package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.MercadoLibreSteps;

public class MercadoLibreTest extends BaseTest {

    private MercadoLibreSteps steps;

   @BeforeMethod(alwaysRun = true)
    public void setUpSteps() {
    steps = new MercadoLibreSteps(driver);
    }

    @Test(groups = {"regresion"})
    @Feature("Validación de categorías")
    @Description("Validar que la categoría de Construcción muestra correctamente sus filtros y títulos.")
    public void validarCategoriaConstruccion() {
        steps.navegarACategoria("Construcción", "Baños y Sanitarios");
        steps.seleccionarCategoriaSecundaria("span","Grifería para Baño");
        steps.validarFiltros("Construcción", "Baños y Sanitarios");
        steps.validarTituloDeCategoria("h2", "Grifería para Baño");
    }

    @Test(groups = {"regresion"})
    @Feature("Validación de categorías")
    @Description("Validar que la categoría de Supermercado muestra correctamente sus filtros y títulos.")
    public void validarCategoriaSupermercado() {
        steps.navegarAlSupermercado();
        steps.seleccionarCategoriaSecundaria("span","CAPSULAS");
        steps.validarFiltros("Alimentos y Bebidas", "Almacén", "Infusiones");
        steps.validarTituloDeCategoria("h1", "Cápsulas en Supermercado");
    }

    @Test(groups = {"regresion"})
    @Feature("Validación de categorías")
    @Description("Validar que la sección de ofertas del día muestra correctamente el título de la categoría.")
    public void validarCategoriaOfertaDelDia() {
        steps.navegarAOfertasDelDia();
        steps.seleccionarCategoriaSecundaria("a","Oferta del día");
        steps.validarTituloDeCategoria("h1", "Todas");
    }

    @Test(groups = {"integracion"})
    @Feature("Validación de categorías")
    @Description("Validar que la categoría Tecnología muestra correctamente sus subcategorías y títulos.")
    public void validarCategoriaTecnologia() {
        steps.navegarACategoria("Tecnología");
        steps.seleccionarCategoriaSecundaria("a","Accesorios para Celulares");
        steps.validarTituloDeCategoria("span", "Celulares y Teléfonos");
        steps.validarTituloDeCategoria("h2", "Accesorios para Celulares");
    }

    @Test(groups = {"precio"})
    @Feature("Validación de filtros de precio")
    @Description("Validar que los filtros de rango de precio en Supermercado funcionan correctamente.")
    public void validarCategoriaSupermercadoFiltrosPrecio() {
        steps.navegarAlSupermercado();
        steps.seleccionarCategoriaSecundaria("span","SALUDABLES");
        steps.aplicarFiltroDePrecioYValidarResultados("10000", "15000");
    }

    @Test(groups = {"precio"})
    @Feature("Validación de filtros de precio")
    @Description("Validar que los filtros de rango de precio en Moda funcionan correctamente.")
    public void validarCategoriaModaOfertasFiltrosPrecio() {
        steps.navegarAModa();
        steps.seleccionarCategoriaSecundaria("span","OFERTAS DEL DÍA");
        steps.aplicarFiltroDePrecioYValidarResultados("10000", "11000");
    }
}
