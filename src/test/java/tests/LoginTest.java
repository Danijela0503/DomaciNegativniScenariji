package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setLoginPage (){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void wrongUserName (){
        loginPage.setWrongUsername();
        Assert.assertTrue(loginPage.errorUsernameText());
    }

    @Test
    public void wrongPassword (){
        loginPage.setWrongPassword();
        Assert.assertTrue(loginPage.errorPasswordText());
    }


    @Test
    public void colorCheck (){
        loginPage.setWrongUsername();
        Assert.assertTrue(loginPage.errorColorField());
    }

    @Test
    public void emptyField (){
        loginPage.emptyField();
        Assert.assertTrue(loginPage.errorUsernameText());
    }


}
