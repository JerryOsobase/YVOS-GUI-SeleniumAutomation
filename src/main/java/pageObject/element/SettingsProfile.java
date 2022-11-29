package pageObject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsProfile {

    WebDriver driver;

    public SettingsProfile(WebDriver driver){
        this.driver=driver;
    }

    private By profileTab = By.cssSelector("a[href*='settings/profile']");
    private By resetPasswordButton = By.xpath("//button/span[contains(text(),'Reset Password')]");
    private By deactivate2faButton = By.xpath("//button/span[contains(text(),'Deactivate user 2FA')]");

    private By firstNameField = By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div > div:nth-child(1) > div > div.content > div.flex-1.p-6.space-y-6 > " +
            "div.grid.grid-cols-1.sm\\:grid-cols-2.xl\\:grid-cols-3.gap-4 > div:nth-child(1) > span > div > input");
    private By lastNameField = By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div > div:nth-child(1) > div > div.content > div.flex-1.p-6.space-y-6 > " +
            "div.grid.grid-cols-1.sm\\:grid-cols-2.xl\\:grid-cols-3.gap-4 > div:nth-child(3) > span > div > input");

    private By emailField = By.xpath("//input[@type='email']");

    private By phoneNumberField = By.xpath("//input[@type='number']");

    private By saveButton = By.xpath("//button/span[contains(text(),'Save Changes')]");

    private By changeButton = By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div > div:nth-child(1) > div > div.content > div.flex-1.p-6.space-y-6 > div.mt-6.space-y-6 > div:nth-child(2) > " +
            "div.flex.justify-between.gap-3.items-center > div:nth-child(2) > button");
    private By currentPasswordField = By.xpath("//input[@placeholder='Enter current password']");
    private By newPasswordField = By.xpath("//input[@placeholder='Enter new password']");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Confirm new password']");
    private By passwordRequirements = By.cssSelector("div[class='grid grid-cols-1 sm:grid-cols-2 gap-4'] " +
            "div[class='grid-item']");
    private By passwordSaveButton= By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-4\\/12.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.uppercase.bg-highlight.text-white.ring-highlight.font-" +
            "medium.py-2.px-4.text-sm.focus\\:ring.disabled.rounded.shadow-none." +
            "focus\\:outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");
    private By passwordCancelButton= By.cssSelector("#content > div > div.mt-4.min-h-full.bg-white.rounded > div:nth-child(2) > div.fixed.flex.items-center.justify-center.inset-0 > div.flex.flex-col.bg-white.w-4\\/12.rounded.overflow-hidden > div.flex-1.flex.flex-col.overflow-hidden > div.flex.justify-end.px-6.pb-6.pt-4.border-t.border-gray-75 > div > button.uppercase.bg-gray-75.text-black-300.ring-gray-75.font-medium.py-2.px-4.text-sm.focus\\:ring.rounded.shadow-none.focus\\" +
            ":outline-none.flex-shrink-0.text-center.ring-opacity-50.relative");
    private By permissionsTab= By.cssSelector("#scrollDiv > button.bg-primary.text-white.ring-highlight.font-semibold.py-3.p" +
            "x-8.text-base.focus\\:ring.rounded.shadow-none.focus\\:outline-none.flex-shrink-0.text-" +
            "center.ring-opacity-50.relative");
    private By activitiesTab= By.cssSelector("#scrollDiv > button.bg-gray-75.text-black-300.ring-gray-75.font-normal." +
            "py-3.px-8.text-base.focus\\:ring.rounded.shadow-none.focus\\:outline-none.flex-shrink-0.text-center.ring-" +
            "opacity-50.relative");
    private By activitiesTableHeader= By.xpath("//tr/th");


    public WebElement getProfileTab() {
        return driver.findElement(profileTab);
    }

    public WebElement getResetPasswordButton() {
        return driver.findElement(resetPasswordButton);
    }

    public WebElement getDeactivate2faButton() {
        return driver.findElement(deactivate2faButton);
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }

    public WebElement getLastNameField() {
        return driver.findElement(lastNameField);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(phoneNumberField);
    }

    public WebElement getSaveButton() {
        return driver.findElement(saveButton);
    }

    public WebElement getChangeButton() {
        return driver.findElement(changeButton);
    }

    public WebElement getCurrentPasswordField() {
        return driver.findElement(currentPasswordField);
    }

    public WebElement getNewPasswordField() {
        return driver.findElement(newPasswordField);
    }

    public WebElement getConfirmPasswordField() {
        return driver.findElement(confirmPasswordField);
    }

    public List<WebElement> getPasswordRequirements() {
        return driver.findElements(passwordRequirements);
    }

    public WebElement getPasswordSaveButton() {
        return driver.findElement(passwordSaveButton);
    }

    public WebElement getPasswordCancelButton() {
        return driver.findElement(passwordCancelButton);
    }

    public WebElement getPermissionsTab() {
        return driver.findElement(permissionsTab);
    }

    public WebElement getActivitiesTab() {
        return driver.findElement(activitiesTab);
    }

    public List<WebElement> getActivitiesTableHeader() {
        return driver.findElements(activitiesTableHeader);
    }

}
