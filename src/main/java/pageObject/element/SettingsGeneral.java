package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsGeneral {

    WebDriver driver;

    public SettingsGeneral(WebDriver driver){
        this.driver=driver;
    }

    private By generalTab = By.cssSelector("div[id='content'] a[href='/settings']");
    private By editButton = By.xpath("//div[@class='border-b border-gray-75'] //button");
    private By tradingNameField = By.cssSelector("input[placeholder='Enter Trading name']");
    private By supportEmailField = By.cssSelector("input[placeholder='Enter Support Email']");
    private By billingEmailField = By.cssSelector("input[placeholder='Enter Billing Email']");
    private By buildingNameField = By.cssSelector("input[placeholder='Enter Building Name']");
    private By flatNumberField = By.cssSelector("input[placeholder='Enter Flat Number']");
    private By buildingNumberField = By.cssSelector("input[placeholder='Enter Building Number']");
    private By landmarkField = By.cssSelector("input[placeholder='Enter Nearest Landmark']");
    private By streetField = By.cssSelector("input[placeholder='Enter Street Name']");
    private By subStreetField = By.cssSelector("input[placeholder='Enter Sub-Street']");
    private By cityField = By.cssSelector("input[placeholder='Enter City']");
    private By supportNumberField = By.cssSelector("input[placeholder='Enter Support Phone Number']");
    private By businessWebsiteField = By.cssSelector("input[placeholder='Business Website Link']");
    private By privacyLinkField = By.cssSelector("input[placeholder='Business Website Link']");
    private By termsOfServiceField = By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-4\\/12.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden >" +
            " div.px-6.h-full.overflow-auto > div > div > span > div > input");
    private By facebookLinkField = By.cssSelector("input[placeholder='Enter Facebook Link']");
    private By twitterLinkField = By.cssSelector("input[placeholder='Enter Twitter Link']");
    private By instagramLinkField = By.cssSelector("input[placeholder='Enter Instagram Link']");
    private By contactFirstNameField = By.cssSelector("input[placeholder='Enter First name']");
    private By contactLastNameField = By.cssSelector("input[placeholder='Enter Last name']");
    private By contactEmailField = By.cssSelector("input[type='email']");
    private By contactNumberField = By.cssSelector("input[placeholder='Enter Phone Number']");
    private By saveButton= By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-4\\/12.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.uppercase.bg-highlight.text-white.ring-highlight.font-medium.py-2.px-4.text-sm.focus\\:" +
            "ring.rounded.shadow-none.focus\\:outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");
    private By cancelButton= By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-4\\/12.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.uppercase.bg-gray-75.text-black-300.ring-gray-75.font-medium.py-2.px-4.text-sm.focus\\" +
            ":ring.rounded.shadow-none.focus\\:outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");


    public WebElement getGeneralTab(){
        return driver.findElement(generalTab);
    }

    public List<WebElement> getEditButton(){
        return driver.findElements(editButton);
    }

    public WebElement getTradingNameField(){
        return driver.findElement(tradingNameField);
    }

    public WebElement getSupportEmailField(){
        return driver.findElement(supportEmailField);
    }

    public WebElement getBillingEmailField(){
        return driver.findElement(billingEmailField);
    }

    public WebElement getBuildingNameField(){
        return driver.findElement(buildingNameField);
    }

    public WebElement getFlatNumberField(){
        return driver.findElement(flatNumberField);
    }

    public WebElement getBuildingNumberField(){
        return driver.findElement(buildingNumberField);
    }

    public WebElement getLandmarkField(){
        return driver.findElement(landmarkField);
    }

    public WebElement getStreetField(){
        return driver.findElement(streetField);
    }

    public WebElement getSubStreetField(){
        return driver.findElement(subStreetField);
    }

    public WebElement getCityField(){
        return driver.findElement(cityField);
    }


    public WebElement getSupportNumberField(){
        return driver.findElement(supportNumberField);
    }

    public WebElement getBusinessWebsiteField(){
        return driver.findElement(businessWebsiteField);
    }

    public WebElement getPrivacyLinkField(){
        return driver.findElement(privacyLinkField);
    }

    public WebElement getTermsOfServiceField(){
        return driver.findElement(termsOfServiceField);
    }

    public WebElement getFacebookLinkField(){
        return driver.findElement(facebookLinkField);
    }

    public WebElement getTwitterLinkField(){
        return driver.findElement(twitterLinkField);
    }

    public WebElement getInstagramLinkField(){
        return driver.findElement(instagramLinkField);
    }

    public WebElement getContactFirstNameField(){
        return driver.findElement(contactFirstNameField);
    }

    public WebElement getContactLastNameField(){
        return driver.findElement(contactLastNameField);
    }

    public WebElement getContactEmailField(){
        return driver.findElement(contactEmailField);
    }

    public WebElement getContactNumberField(){
        return driver.findElement(contactNumberField);
    }

    public WebElement getSaveButton(){
        return driver.findElement(saveButton);
    }

    public WebElement getCancelButton(){
        return driver.findElement(cancelButton);
    }

}
