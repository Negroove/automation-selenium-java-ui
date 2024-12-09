package base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

//Clase base donde configuraremos 
public class BaseTest {
    protected WebDriver driver;

    // antes del test case 
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", ConfigReader.get("browser"));
        
         // Validar el valor del navegador
         if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // si no especifica navegador se ejecuta automaticamente en chrome 
            System.out.println("NAVEGADOR NO ESPEFICIADO, USANDO CHROME");
        } else {
            browser = browser.toLowerCase();
            System.out.println("EJECUTANDO PRUEBAS EN " + browser);
        }
        
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
            break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //maximizo la ventana
        driver.manage().window().maximize();

        //voy a la url 
        driver.get(ConfigReader.get("baseUrl"));
    }

    // despues del test case 
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
