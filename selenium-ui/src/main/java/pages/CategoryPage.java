package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"hub\"]/div[2]/section/section/div/a") 
    private WebElement btnSeeAll;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']") 
    private WebElement lblResults;

    public CategoryPage(WebDriver driver) {
        super(driver);
        waitForPageToLoad();
    }

    public String getTextByElement(String tag, String expectedText) {
        WebElement element = findElementByText(tag, expectedText);
        return element.getText();
    }

    public void validateTextByElement(String tag, String expectedText) {
        String actualText = getTextByElement(tag, expectedText);
        Assert.assertEquals(actualText, expectedText, "El texto no coincide con el esperado.");
    }

    public void goTo3rdCategory(String tag, String text){
        WebElement terceraCategoria = findElementByText(tag, text);
        click(terceraCategoria);
    }

    public void seeAllProducts(){
        click(btnSeeAll);
    }

    public void addTagSearch(String tag){
        WebElement btnTag =  driver.findElement(By.xpath("//span[@class='ui-search-filter-name'][normalize-space()='"+tag+"']"));
        click(btnTag);
    }

    public void checkResults(){
        String totalResults = getTotalResults();
        getTotalResults();
        System.out.println("Total de resultados: " + totalResults);
        Assert.assertNotNull(totalResults, "El total de resultados no debe ser nulo.");
    }

    // Obtener el total de resultados
    public String getTotalResults() {
        System.out.println("LOS RESULTADOS SON: " + lblResults.getText());
        return lblResults.getText();
    }
}
