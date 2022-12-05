package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Identity {

    WebDriver driver;

    public Identity(WebDriver driver) {
        this.driver = driver;
    }

    private By pageHeader = By.cssSelector("div[class*='font-bold text-title']");
    private By identityCheckButton = By.xpath("//button/span[contains(text(),'Check')]");

    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }

    public WebElement getIdentityCheckButton(){
        return driver.findElement(identityCheckButton);
    }

}
