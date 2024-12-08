package tests;

import base.BaseTest;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleTest extends BaseTest {

    @Test
    public void abrirGoogle() {
       String expectedUrl = ConfigReader.get("baseUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Base URL does not match!");
    }
}
