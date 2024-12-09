package tests;

import base.BaseTest;
import pages.CategoryPage;
import pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MercadoLibreTest extends BaseTest {

    @Test(groups = { "regresion" })
    public void validarCategoriaConstruccion() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // El test se incia abriendo directmaente la direccion de mercadolibre desde la
        // clase BaseTest
        homePage.goToCategory("Construcción", "Baños y Sanitarios");

        categoryPage.goTo3rdCategory("span", "Grifería para Baño");

        categoryPage.validateTextByElement("span", "Construcción");
        categoryPage.validateTextByElement("span", "Baños y Sanitarios");
        categoryPage.validateTextByElement("h2", "Grifería para Baño");
        
    }


    @Test(groups = { "regresion" })
    public void validarCategoriaConstruccion3() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // El test se incia abriendo directmaente la direccion de mercadolibre desde la
        // clase BaseTest
        homePage.goToCategory("Construcción", "Baños y Sanitarios");

        categoryPage.goTo3rdCategory("span", "Grifería para Baño");

        categoryPage.validateTextByElement("span", "Construcción");
        categoryPage.validateTextByElement("span", "Baños y Sanitarios");
        categoryPage.validateTextByElement("h2", "Grifería para Baño");
        
    }
    @Test(groups = { "regresion" })
    public void validarCategoriaConstruccion2() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // El test se incia abriendo directmaente la direccion de mercadolibre desde la
        // clase BaseTest
        homePage.goToCategory("Construcción", "Baños y Sanitarios");

        categoryPage.goTo3rdCategory("span", "Grifería para Baño");

        categoryPage.validateTextByElement("span", "Construcción");
        categoryPage.validateTextByElement("span", "Baños y Sanitarios");
        categoryPage.validateTextByElement("h2", "Grifería para Baño");
        
    }
    @Test(groups = { "regresion" })
    public void validarCategoriaConstruccion1() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        // El test se incia abriendo directmaente la direccion de mercadolibre desde la
        // clase BaseTest
        homePage.goToCategory("Construcción", "Baños y Sanitarios");

        categoryPage.goTo3rdCategory("span", "Grifería para Baño");

        categoryPage.validateTextByElement("span", "Construcción");
        categoryPage.validateTextByElement("span", "Baños y Sanitarios");
        categoryPage.validateTextByElement("h2", "Grifería para Baño");
        
    }

}
