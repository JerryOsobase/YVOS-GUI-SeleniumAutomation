package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideMenu {

    WebDriver driver;

    public SideMenu(WebDriver driver){
        this.driver=driver;
    }

    private By getStarted = By.cssSelector("a[href*='/get-started']");
    private By vForms = By.cssSelector("div[class*='flex-1 overflow-auto'] a[href='/v-forms']");
    private By sdk = By.xpath("//div[@class='cursor-pointer'] //div[contains(text(), 'SDK')]");
    private By livenessCheck = By.cssSelector("a[href*='/liveness-check']");
    private By documentCapture = By.cssSelector("a[href*='/document-capture']");
    private By verification = By.xpath("//div[@class='cursor-pointer'] //div[contains(text()," +
            " 'Verification')]");
    private By identity = By.cssSelector("a[href*='/identity']");
    private By address = By.cssSelector("a[href*='/address']");
    private By companyCheck = By.cssSelector("a[href*='/company-check']");
    private By aml = By.cssSelector("a[href*='/aml']");
    private By businesses = By.cssSelector("a[href*='/businesses']");
    private By billing = By.cssSelector("a[href*='/billing']");
    private By users = By.cssSelector("a[href*='/users']");
    private By settings = By.cssSelector("a[href*='/settings']");
    private By auditLog = By.cssSelector("div[class*='flex-1 overflow-auto'] a[href*='/audit-log']");

    private By sideMenuList = By.xpath("//ul //li");

    public WebElement getStarted(){
        return driver.findElement(getStarted);
    }

    public WebElement getVForms(){
        return driver.findElement(vForms);
    }

    public List<WebElement> getSideMenuList(){
        return driver.findElements(sideMenuList);
    }

    public WebElement getSdk(){
        return driver.findElement(sdk);
    }

    public WebElement getLivenessCheck(){
        return driver.findElement(livenessCheck);
    }

    public WebElement getDocumentCapture(){
        return driver.findElement(documentCapture);
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

    public WebElement getBusinesses(){
        return driver.findElement(businesses);
    }

    public WebElement getBilling(){
        return driver.findElement(billing);
    }

    public WebElement getUsers(){
        return driver.findElement(users);
    }

    public WebElement getSettings(){
        return driver.findElement(settings);
    }

    public WebElement getAuditLog(){
        return driver.findElement(auditLog);
    }


}
