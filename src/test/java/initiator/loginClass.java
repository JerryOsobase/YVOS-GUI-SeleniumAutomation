package initiator;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObject.element.AdminLogin;
import pageObject.element.BusinessLogin;
import pageObject.element.GetStarted;
import pageObject.element.Login;
import resources.base;

import java.io.IOException;
import java.util.HashMap;

public abstract class loginClass extends base{
    Login l = null;

    public void emptyEmailField(){
        l = new Login(driver);
        Assert.assertFalse(l.getNextButton().isEnabled());
    }

    public void invalidEmailFormat(HashMap<String, String> data){
        l = new Login(driver);
        l.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), data.get("invalidEmail"));
        Assert.assertFalse(l.getNextButton().isEnabled());
    }

    public void invalidLogin() throws IOException {
        String packageName = this.getClass().getPackageName();
        if(packageName=="admin"){
            l = new AdminLogin(driver);
        } else if (packageName=="business") {
            l = new BusinessLogin(driver);
        }
        l.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), l.getEmail());
        l.getNextButton().click();
        l.getPasswordField().sendKeys(Keys.chord(Keys.COMMAND,"a"), "Fraboy6@");
        l.getLoginButton().click();
        System.out.println(l.getPopUpMessage().getText());
        Assert.assertTrue(l.getPopUpMessage().getText().contains("Invalid credentials"));
        l.getBackButton().click();
    }

    public Object login() throws IOException{

        String packageName = this.getClass().getPackageName();
        if(packageName=="admin"){
            l = new AdminLogin(driver);
        } else if (packageName=="business") {
            l = new BusinessLogin(driver);
        }
        l.getEmailAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), l.getEmail());
        l.getNextButton().click();
        l.getPasswordField().sendKeys(Keys.chord(Keys.COMMAND, "a"), l.getPassword());
        l.getLoginButton().click();
        GetStarted gs = new GetStarted(driver);
        Assert.assertEquals(gs.getPageHeader().getText(), "Get Started");
        return null;
    }
}
