package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.time.Duration;


public class Login extends base {
		private String email;
		private String password;

		private By emailAddressField = By.xpath("//input[@type='email']");
		private By passwordField = By.cssSelector("input[placeholder='Enter password']");
		private By loginButton = By.cssSelector("#__layout > div > div.flex-1.px-6.py-10" +
				".overflow-y-auto.order-last.md\\:order-first > div > div > div > div:nth-child(2) > span > button");
		private By nextButton = By.cssSelector("#__layout > div > div.flex-1.px-6.py-10.overflow-y-aut" +
				"o.order-last.md\\:order-first > div > div > div > div:nth-child(2) > span > div.text-center > button");

		public static  By popUpMessage = By.cssSelector("span div[class*='message space-x-2']");

	private By backButton = By.cssSelector("#__layout > div > div.flex-1.px-6.py-10.overflow-y-auto.order-last.md\\:order-first > div > div >" +
			" div > div:nth-child(2) > span > div:nth-child(1) > button");

	private By fieldErrorMessage = By.cssSelector("div[class*='text-red']");


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

		public WebElement getEmailAddressField() {
			 return driver.findElement(emailAddressField);
		}

	public WebElement getFieldErrorMessage() {
		return driver.findElement(fieldErrorMessage);
	}

	public static WebElement getPopUpMessage() {
		wait = new WebDriverWait(driver, durationInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
			return driver.findElement(popUpMessage);
	}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}

	public WebElement getBackButton() {
		return driver.findElement(backButton);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

		public WebElement getPasswordField(){
			return driver.findElement(passwordField);
		}

		}
