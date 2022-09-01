package admin;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test4{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//jerryosobase//Applications//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href*='new']")).click();
		Set<String> win = driver.getWindowHandles();
		for(String tab : win) {
			System.out.println(driver.switchTo().window(tab).getTitle());
		}
		driver.quit();
	}

}
