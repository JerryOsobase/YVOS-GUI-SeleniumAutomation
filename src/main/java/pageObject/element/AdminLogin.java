package pageObject.element;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AdminLogin extends Login{

    public Properties prop;

    public AdminLogin(WebDriver driver) throws IOException {
        super(driver);
        prop = new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//"
                + "main//java//resources//data.properties");
        prop.load(fis);
        setEmail(prop.getProperty("adminEmail"));
        setPassword(prop.getProperty("adminPassword"));
    }
}
