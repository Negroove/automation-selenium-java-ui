package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleTest extends BaseTest {

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
