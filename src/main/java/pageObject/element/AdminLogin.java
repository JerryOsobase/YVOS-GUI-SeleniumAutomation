package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AdminLogin {

	public WebDriver driver;
		
		public AdminLogin(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}

		private By emailAddressField= By.id("");
		
				
		public WebElement getEmailAddressField() {
			return driver.findElement(emailAddressField);
		}
		
		}
