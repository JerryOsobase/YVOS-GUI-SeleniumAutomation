package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.util.List;

public class GetStarted extends base {

    WebDriver driver;

    public GetStarted(WebDriver driver){
        this.driver=driver;
    }

    private By pageHeader = By.cssSelector("div[class*='text-xl']");

    private By modalTitle = By.cssSelector("div[class*='mt-6 card'] h2");
    private By letGoLink = By.cssSelector("div[class*='card grid gap-2'] a");
    private By letGoButton = By.cssSelector("div[class*='card grid gap-2'] button");



    public WebElement getPageHeader(){
        return driver.findElement(pageHeader);
    }

    public List<WebElement> getLetGoLink(){
        return driver.findElements(letGoLink);
    }

    public WebElement getLetGoButton(){
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(letGoButton));
        return driver.findElement(letGoButton);
    }

    public List<WebElement> getModalTitle(){
        return driver.findElements(modalTitle);
    }

}
