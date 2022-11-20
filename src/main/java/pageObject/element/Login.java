package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {

	public WebDriver driver;

		public Login(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}

		private String email;
		private String password;

		private By emailAddressField = By.xpath("//input[@type='email']");
		private By passwordField = By.xpath("//input[@type='password']");
		private By loginButton = By.cssSelector("#__layout > div > div.flex-1.px-6.py-10" +
				".overflow-y-auto.order-last.md\\:order-first > div > div > div > div:nth-child(2) > span > button");
		private By nextButton = By.cssSelector("#__layout > div > div.flex-1.px-6.py-10.overflow-y-aut" +
				"o.order-last.md\\:order-first > div > div > div > div:nth-child(2) > span > div.text-center > button");


		public String getEmail(){
			return email;
		}

		public void setEmail(String newEmail){
			email = newEmail;
		}

		public String getPassword(){
			return password;
		}

		public void setPassword(String newPassword){
			password = newPassword;
		}

		public void getEmailAddressField() {
			 driver.findElement(emailAddressField).sendKeys(getEmail());
		}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

		public void getPasswordField(){
			driver.findElement(passwordField).sendKeys(getPassword());
		}

		}
