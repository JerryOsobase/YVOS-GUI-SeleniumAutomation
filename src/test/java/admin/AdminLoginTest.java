package admin;

import java.io.IOException;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.element.AdminLogin;
import pageObject.element.BusinessLogin;
import pageObject.element.Login;
import resources.base;

public class AdminLoginTest extends base{


		@BeforeClass
		public void initialize() throws IOException {
			driver= InitializeBrowser();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();

		}
		
		@Test
		public void test() throws InterruptedException {
			System.out.println("hello world");
		}
		
		
		
		
		@AfterClass
		public void terminate() {
		driver.close();
		}
	}


