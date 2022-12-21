package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class Identity extends base {

    private By pageHeader = By.cssSelector("div[class*='font-bold text-title']");
    private By identityCheckButton = By.xpath("//button/span[contains(text(),'Check')]");

    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }

    public WebElement getIdentityCheckButton(){
        return driver.findElement(identityCheckButton);
    }

}
