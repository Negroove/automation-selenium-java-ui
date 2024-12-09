package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// clase para metodos genericos que pueden utilizar otras pages 
public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForPageToLoad();
        PageFactory.initElements(driver, this);
    }

    // elementos xpath simples 
    protected WebElement findElementByText(String tag, String text) {
        String xpath = "//" + tag + "[normalize-space()='" + text + "']";
        waitForElementIsPresent(By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    protected void waitForElementIsPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForElementIsPresent(String tag, String text) {
        String xpath = "//" + tag + "[normalize-space()='" + text + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForClickeable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void click(WebElement element) {
        waitForPageToLoad();
        waitForClickeable(element);
        element.click();
    }

    // metodo para enviar texto a un campo
    protected void type(WebElement element, String text) {
        waitForClickeable(element);
        element.clear();
        element.sendKeys(text);
    }

    // metodo para obtener texto
    protected String getText(WebElement element) {
        waitForClickeable(element);
        return element.getText();
    }

    // scrollea hacia elemento
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // espera a que la pagina este cargada
    protected void waitForPageToLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                    .equals("complete"));
        } catch (Exception e) {
            throw new RuntimeException("Error al esperar que la página cargue.", e);
        }
    }

    // espera a que el elemento este listo
    protected void waitForElementToBeReady(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)); // Espera visibilidad
        wait.until(ExpectedConditions.elementToBeClickable(element)); // Espera que sea clickeable
    }
}
