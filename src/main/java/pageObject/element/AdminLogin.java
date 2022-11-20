package pageObject.element;

import org.openqa.selenium.WebDriver;

public class AdminLogin extends Login{


    public AdminLogin(WebDriver driver) {
        super(driver);
        setEmail("jerry@youverify.co");
        setPassword("Base4jerry@");
    }
}
