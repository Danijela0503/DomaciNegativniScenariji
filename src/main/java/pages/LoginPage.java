package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Constants;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.className("radius");
    private By errorField = By.cssSelector(".flash.error");


    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void typeIn(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public void click (By locator){
        getElement(locator).click();
    }

    public void setWrongUsername() {
        typeIn(usernameField, Constants.wrongUSERNAME);
        typeIn(passwordField, Constants.PASSWORD);
        click(loginButton);
    }

    public void setWrongPassword() {
        typeIn(usernameField, Constants.USERNAME);
        typeIn(passwordField, Constants.wrongPASSWORD);
        click(loginButton);
    }

    public void emptyField () {
        click(loginButton);
    }

    public boolean errorUsernameText() {
        String[] actualTextIzvorno = getElement(errorField).getText().split("(?<=!)");
        String actualText = actualTextIzvorno[0];
        String expectedText = "Your username is invalid!";
        return expectedText.equals(actualText.trim());
    }

    public boolean errorPasswordText() {
        String[] actualTextIzvorno = getElement(errorField).getText().split("(?<=!)");
        String actualText = actualTextIzvorno[0];
        String expectedText = "Your password is invalid!";
        return expectedText.equals(actualText.trim());
    }

    public boolean errorColorField() {
        String actualColor = getElement(errorField).getCssValue("background-color");
        String expectedColor = "rgba(198, 15, 19, 1)";
        return expectedColor.equals((actualColor));
    }




}
