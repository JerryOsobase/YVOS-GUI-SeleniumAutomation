package pageObject.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class emp {
		public WebDriver driver;
			
			public emp(WebDriver driver) {
				// TODO Auto-generated constructor stub
				this.driver=driver;
			}
			
			private By addressHeader= By.xpath("");
			
			public WebElement getAddressHeader() {
				return driver.findElement(addressHeader);
			}
}
			
		