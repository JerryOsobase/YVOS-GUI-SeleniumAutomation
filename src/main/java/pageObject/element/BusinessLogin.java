package pageObject.element;

import org.openqa.selenium.WebDriver;
import resources.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BusinessLogin extends Login{

public Properties prop;
    public BusinessLogin() throws IOException {
        prop = new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//"
                + "main//java//resources//data.properties");
        prop.load(fis);
        setEmail(prop.getProperty("businessEmail"));
        setPassword(prop.getProperty("businessPassword"));
    }
}