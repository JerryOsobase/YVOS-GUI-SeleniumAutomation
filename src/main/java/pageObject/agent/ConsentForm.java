package pageObject.agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsentForm {
public WebDriver driver;
	
	public ConsentForm(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
private By cancelButton= By.xpath("//button[text()='Cancel']");
private By continueButton= By.xpath("//button[text()=' I Understand, Continue ']");
private By pageHeader= By.cssSelector("h1.mt-5.text-center");



public WebElement getcancelButton() {
	return driver.findElement(cancelButton);
}
public WebElement getcontinueButton() {
	return driver.findElement(continueButton);
}

public WebElement getpageHeader() {
	return driver.findElement(pageHeader);
}
}