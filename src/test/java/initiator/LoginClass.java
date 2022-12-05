package initiator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObject.element.AdminLogin;
import pageObject.element.BusinessLogin;
import pageObject.element.GetStarted;
import pageObject.element.Login;
import resources.base;

import java.io.IOException;
import java.util.HashMap;

public class LoginClass extends base{
    Login login = null;
    SoftAssert softAssert;

    GetStarted getStarted;


    public void emptyEmailField(){
        login = new Login(driver);
        Assert.assertFalse(login.getNextButton().isEnabled());
    }

    public void invalidEmailFormat(HashMap<String, String> data){
        login = new Login(driver);
        softAssert = new SoftAssert();
        login.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), data.get("invalidEmail"));
        softAssert.assertEquals(login.getFieldErrorMessage().getText(),"The Email field has to be a valid email");
        softAssert.assertFalse(login.getNextButton().isEnabled());
        softAssert.assertAll();
    }

    public void invalidLogin() throws IOException {
        if(packageName=="admin"){
            login = new AdminLogin(driver);
        } else if (packageName=="business") {
            login = new BusinessLogin(driver);
        }
        login.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), login.getEmail());
        login.getNextButton().click();
        login.getPasswordField().sendKeys(Keys.chord(Keys.COMMAND,"a"), "Fraboy6@");
        login.getLoginButton().click();
        Assert.assertTrue(login.getPopUpMessage().getText().contains("Invalid credentials"));
        login.getBackButton().click();
    }

    public void validLogin() throws IOException {
        login();
        getStarted = new GetStarted(driver);
        Assert.assertEquals(getStarted.getPageHeader().getText(), "Get Started");
    }


    public Object login() throws IOException{
        if(packageName=="admin"){
            login = new AdminLogin(driver);
        } else if (packageName=="business") {
            login = new BusinessLogin(driver);
        }
        login.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), login.getEmail());
        login.getNextButton().click();
        login.getPasswordField().sendKeys(Keys.chord(Keys.COMMAND, "a"), login.getPassword());
        login.getLoginButton().click();
        return null;
    }
}
