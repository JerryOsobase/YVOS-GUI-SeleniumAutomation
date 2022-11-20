package pageObject.element;

import org.openqa.selenium.WebDriver;
import resources.base;

public class BusinessLogin extends Login{


    public BusinessLogin(WebDriver driver) {
        super(driver);
        setEmail("jerryosobase4+001@gmail.com");
        setPassword("Osobase4@");
    }
}