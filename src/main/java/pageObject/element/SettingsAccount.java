package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsAccount {
    WebDriver driver;

    public SettingsAccount(WebDriver driver){
        this.driver=driver;
    }

    private By button = By.xpath("//div[@class='border-b border-gray-75'] //button");
    private By toggle = By.xpath("//div[@class='border-b border-gray-75'] //div[@class='switch']");
    private By settingsName = By.xpath("//div[@class='border-b border-gray-75']" +
            " //div[@class='flex-1']/div[1]");
    private By accountSettingsTab = By.cssSelector("a[href*='settings/account']");

    public List<WebElement> getButton(){
        return driver.findElements(button);
    }

    public List<WebElement> getToggle(){
        return driver.findElements(toggle);
    }

    public List<WebElement> getSettingsName(){
        return driver.findElements(settingsName);
    }

    public WebElement getAccountSettingsTab(){
        return driver.findElement(accountSettingsTab);
    }

}
