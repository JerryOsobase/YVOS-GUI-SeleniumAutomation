package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class FrontDesk extends base {

    private By pageHeader = By.cssSelector("div.c-wrapper h2");

    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }

}
