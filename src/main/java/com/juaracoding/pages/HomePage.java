package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtAppLogo;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBtnToCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement txtChekout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private  WebElement continuee;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finish;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHome;

    public void home () {
        txtAppLogo.getText();
        DriverSingleton.delay(1);
        addBtnToCart.click();
        DriverSingleton.delay(1);
        cartBtn.click();
        DriverSingleton.delay(1);
        txtCartBadge.getText();
        DriverSingleton.delay(1);
        txtChekout.click();
    }

    public void chekout (String name, String namelast, String zip){
        DriverSingleton.delay(1);
        firstName.sendKeys(name);
        DriverSingleton.delay(1);
        lastName.sendKeys(namelast);
        DriverSingleton.delay(1);
        postalCode.sendKeys(zip);
        DriverSingleton.delay(1);
        continuee.click();
        DriverSingleton.delay(1);
        finish.click();
        DriverSingleton.delay(1);
        backHome.click();
    }

    public String getTxtAppLogo(){
        return txtAppLogo.getText();
    }
}
