package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetStarted {

    WebDriver driver;

    public GetStarted(WebDriver driver){
        this.driver=driver;
    }

    private By pageHeader = By.cssSelector("div[class*='text-xl']");

    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }
}
