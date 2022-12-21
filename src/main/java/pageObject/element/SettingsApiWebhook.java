package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.base;

import java.util.List;

public class SettingsApiWebhook extends base {

    private By webhookTab = By.cssSelector("a[href*='/settings/api-webhooks']");
    private By createApiKeyButton = By.xpath("//button/span[contains(text(),'Create new API key')]");
    private By keyNameField = By.cssSelector("input[placeholder='Enter Name']");
    private By keyDescriptionField = By.cssSelector("textarea[placeholder='Enter Description']");
    private By keyCheckbox = By.cssSelector("div[class*='font-semibold mb-3'] span.checkmark");
    private By saveApiKeyButton = By.xpath("//button/span[contains(text(),'Create API Key')]");
    private By keyActionButton = By.xpath("//div[@class='px-6 space-y-12']/div[1] //tbody/tr/td[7] //button");
    private By keyName = By.xpath("//div[@class='px-6 space-y-12']/div[1] //tbody/tr/td[1]");
    private By keyDescription = By.xpath("//div[@class='px-6 space-y-12']/div[1] //tbody/tr/td[2]");
    private By visibilityEyeIcon = By.cssSelector("div[class*='border-b border-gray-75'] div[class*='visibility']");
    private By copyIcon = By.cssSelector("div[class*='border-b border-gray-75'] div[class*='copy']");
    private By generateNewWebhookKeyButton = By.xpath("//button/span[contains(text(),'Generate new key')]");
    private By changeWebhookUrlButton = By.xpath("//button/span[contains(text(),'Change')]");
    private By webhookUrlField = By.cssSelector("input[placeholder='Enter Webhook URL']");
    private By addIpAddressButton = By.xpath("//button/span[contains(text(),'Add IP Address')]");
    private By ipAddressField = By.cssSelector("input[placeholder='Enter IP Address']");
    private By ipCommentField = By.cssSelector("input[placeholder='Enter Comment']");
    private By saveIpAddressButton = By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-5\\/6.sm\\:w-4\\/6.md\\:w-1\\/2.xl\\:w-2\\/6.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > " +
            "div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > button");

    private By ipAddress = By.xpath("//div[@class='px-6 space-y-12']/div[3] //tbody/tr/td[1]");
    private By ipActionButton = By.xpath("//div[@class='px-6 space-y-12']/div[3] //tbody/tr/td[6] //button");
    private By editButton = By.xpath("//div[text()='Edit']");
    private By deleteButton = By.xpath("//div[text()='Delete']");
    private By deleteConfirmationButton = By.xpath("//button/span[contains(text(),'Yes, delete')]");
    private By updateButton = By.xpath("//button/span[contains(text(),'Update')]");

    private By pageHeader = By.cssSelector("div.header div");

    private By popUpCloseButton = By.xpath("//button/span[contains(text(),'Close')]");

    private By tableHeader = By.xpath("//div[@class='px-6 space-y-12']/div[1] //tr/th");

    private By ipTableHeader = By.xpath("//div[@class='px-6 space-y-12']/div[3] //tr/th");

    private By currentIpAddress = By.xpath("//button/span[contains(text(),'Current IP Address')]");

    private By webHookTitle = By.cssSelector("div.px-0 div[class*='text-black-300']");

    private By webHookKeys = By.cssSelector("div.px-0 div[class*='flex-2'] div[class*='flex-1']");


    public WebElement getWebhookTab() {
        return driver.findElement(webhookTab);
    }

    public List<WebElement> getWebHookTitle() {
        return driver.findElements(webHookTitle);
    }

    public List<WebElement> getWebHookKeys() {
        return driver.findElements(webHookKeys);
    }

    public List<WebElement> getIpTableHeader() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ipTableHeader));
        return driver.findElements(ipTableHeader);
    }

    public WebElement getCurrentIpAddress() {
        return driver.findElement(currentIpAddress);
    }

    public List<WebElement> getTableHeader() {
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableHeader));
        return driver.findElements(tableHeader);
    }

    public List<WebElement> getPageHeader(){
        return driver.findElements(pageHeader);
    }

    public WebElement getPopUpCloseButton() {
        return driver.findElement(popUpCloseButton);
    }

    public WebElement getCreateApiKeyButton(){
        return driver.findElement(createApiKeyButton);
    }

    public List<WebElement> getIpAddress(){
        return driver.findElements(ipAddress);
    }

    public WebElement getKeyNameField(){
        return driver.findElement(keyNameField);
    }

    public WebElement getKeyDescriptionField(){
        return driver.findElement(keyDescriptionField);
    }

    public List<WebElement> getKeyCheckbox(){
        return driver.findElements(keyCheckbox);
    }

    public WebElement getSaveApiKeyButton(){
        return driver.findElement(saveApiKeyButton);
    }

    public List<WebElement> getKeyActionButton(){
        return driver.findElements(keyActionButton);
    }

    public List<WebElement> getKeyName(){
        return driver.findElements(keyName);
    }

    public WebElement getKeyDescription(){
        return driver.findElement(keyDescription);
    }

    public List<WebElement> getVisibilityEyeIcon(){
        return driver.findElements(visibilityEyeIcon);
    }

    public List<WebElement> getCopyIcon(){
        return driver.findElements(copyIcon);
    }

    public WebElement getGenerateNewWebhookKeyButton(){
        return driver.findElement(generateNewWebhookKeyButton);
    }

    public WebElement getChangeWebhookUrlButton(){
        return driver.findElement(changeWebhookUrlButton);
    }

    public WebElement getWebhookUrlField(){
        return driver.findElement(webhookUrlField);
    }

    public WebElement getAddIpAddressButton(){
        return driver.findElement(addIpAddressButton);
    }

    public WebElement getIpAddressField(){
        return driver.findElement(ipAddressField);
    }

    public WebElement getIpCommentField(){
        return driver.findElement(ipCommentField);
    }

    public WebElement getSaveIpAddressButton(){
        return driver.findElement(saveIpAddressButton);
    }

    public List<WebElement> getIpActionButton(){
        return driver.findElements(ipActionButton);
    }

    public WebElement getEditButton(){
        return driver.findElement(editButton);
    }

    public WebElement getDeleteButton(){
        return driver.findElement(deleteButton);
    }

    public WebElement getDeleteConfirmationButton(){
        return driver.findElement(deleteConfirmationButton);
    }

    public WebElement getUpdateButton(){
        return driver.findElement(updateButton);
    }


}
