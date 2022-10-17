package admin;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.base;

public class AdminLoginTest extends base{


		@BeforeClass
		public void initialize() throws IOException {
			driver= InitializeBrowser();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		
		@Test
		public void test() {
		}
		
		
		
		
		@AfterClass
		public void terminate() {
		driver.close();
		}
	}


