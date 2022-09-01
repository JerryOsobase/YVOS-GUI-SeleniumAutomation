package admin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import resources.base;

public class Test3 extends base{
	
@SuppressWarnings("deprecation")
@Test
public void Init() throws IOException {
	driver= InitializeBrowser();
	driver.get("https://the-internet.herokuapp.com/");
	driver.manage().window().maximize();
	String url = driver.findElement(By.cssSelector("a[href*='dynamic_loading']")).getAttribute("href");
	HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
	con.setRequestMethod("Head");
	con.connect();
	int code = con.getResponseCode();
	System.out.println(code);
	driver.quit();
}

}