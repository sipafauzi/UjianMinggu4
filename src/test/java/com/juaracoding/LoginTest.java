package com.juaracoding;


import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    private LoginPage loginPage;

    private HomePage homePage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testLoginValid(){
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.getTxtAppLogo(), "Swag Labs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 2)
    public void testHomePage(){
        homePage.home();
        Assert.assertEquals(homePage.getTxtAppLogo(), "Swag Labs");

    }

    @Test(priority = 3)
    public void testChekout(){
        homePage.chekout("sipa","fauzi","123");
    }


}
