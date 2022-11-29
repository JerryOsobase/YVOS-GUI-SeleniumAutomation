package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageBusinessSideMenu {
    WebDriver driver;

    public ManageBusinessSideMenu(WebDriver driver){
        this.driver=driver;
    }

    private By organization = By.cssSelector("a[href*='/organization']");
    private By verification = By.xpath("//div[@class='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "//div[@class='cursor-pointer'] //div[contains(text(),'Verification')]");
    private By identity = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/identity']");
    private By address = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/address']");
    private By companyCheck = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/company-check']");
    private By aml = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/aml']");
    private By billing = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/billing']");
    private By users = By.cssSelector("div[class*='w-64 flex flex-col h-full z-10 bg-primary transition-all duration-300 ease-in-out'] " +
            "a[href*='/users']");

    private By manage = By.xpath("//div[contains(text(), 'Manage')]");

    public WebElement getOrganization(){
        return driver.findElement(organization);
    }

    public WebElement getVerification(){
        return driver.findElement(verification);
    }

    public WebElement getIdentity(){
        return driver.findElement(identity);
    }

    public WebElement getAddress(){
        return driver.findElement(address);
    }

    public WebElement getCompanyCheck(){
        return driver.findElement(companyCheck);
    }

    public WebElement getAml(){
        return driver.findElement(aml);
    }

    public WebElement getBilling(){
        return driver.findElement(billing);
    }

    public WebElement getUsers(){
        return driver.findElement(users);
    }

    public WebElement getManage(){
        return driver.findElement(manage);
    }
}
