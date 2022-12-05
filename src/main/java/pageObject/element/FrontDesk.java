package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrontDesk {

    WebDriver driver;

    public FrontDesk(WebDriver driver){
        this.driver=driver;
    }

    private By pageHeader = By.cssSelector("div.c-wrapper h2");

    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }

}
