package initiator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObject.element.SettingsApiWebhook;
import pageObject.element.SettingsGeneral;
import pageObject.element.SettingsProfile;
import pageObject.element.SideMenu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static pageObject.element.Login.getPopUpMessage;

public class SettingClass extends LoginClass{

    SettingsProfile settingsProfile;
    SideMenu sideMenu;

    SoftAssert softAssert;

    SettingsGeneral settingsGeneral;

    JavascriptExecutor executor;

    SettingsApiWebhook settingsApiWebhook;

    String apiKey = "Automation Test Key";

    String description = "Automation Test Description";

    String ipAddress;

    public void validateSettingProfilePage(){
        settingsProfile = new SettingsProfile();
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", settingsProfile.getProfileTab());
        Assert.assertEquals(settingsProfile.getPageHeader().getText(), "User Information");

    }

    public void userInformation(){
        settingsProfile = new SettingsProfile();
        List<String> originalLabelList = settingsProfile.getUserInfoLabel().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedLabel = {"First Name\n" + "*", "Middle Name", "Last Name\n" + "*", "Email Address", "Phone Number\n" + "*"};
        List<String> expectedLabelList = Arrays.asList(expectedLabel);
        Assert.assertEquals(originalLabelList, expectedLabelList);
    }

    public void userInformationUpdate() throws InterruptedException {
        settingsProfile = new SettingsProfile();
        softAssert = new SoftAssert();
        String originalFirstName = settingsProfile.getFirstNameField().getAttribute("value");
        String originalLastName = settingsProfile.getLastNameField().getAttribute("value");
        settingsProfile.getFirstNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), "test");
        settingsProfile.getLastNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), "test");
        settingsProfile.getSaveButton().click();
        softAssert.assertEquals(settingsProfile.getFirstNameField().getAttribute("value"), "test");
        softAssert.assertEquals(settingsProfile.getLastNameField().getAttribute("value"), "test");
        softAssert.assertFalse(settingsProfile.getEmailField().isEnabled());
        Thread.sleep(1500);
        settingsProfile.getFirstNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), originalFirstName);
        settingsProfile.getLastNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), originalLastName);
        settingsProfile.getSaveButton().click();
        softAssert.assertAll();
        while(true){
            try{
                wait = new WebDriverWait(driver, durationInSeconds);
                wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
            }
            catch (Exception e){
                break;
            }
        }

    }

    public void validateSettingsGeneralPage(){
        sideMenu = new SideMenu();
        settingsGeneral =new SettingsGeneral();
        sideMenu.getSettings().click();
        List<String> originalLabelList = settingsGeneral.getSectionHeader().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedLabel = {"Business Information", "Contact Person"};
        List<String> expectedLabelList = Arrays.asList(expectedLabel);
        Assert.assertEquals(originalLabelList, expectedLabelList);
    }

    public void generalInformation(){
        settingsGeneral =new SettingsGeneral();
        List<String> originalLabelList = settingsGeneral.getInformationLabel().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedLabel = {"Trading Name", "Support Email", "Billing Email", "Office Address", "Country", "Support Phone Number", "Business Website Link", "Legal Business Name", "Privacy Link", "Terms of Service Link", "Social Links", "Business Logo", "Contact Name", "Contact Email", "Contact Phone Number"};
        List<String> expectedLabelList = Arrays.asList(expectedLabel);
        Assert.assertEquals(originalLabelList, expectedLabelList);
    }

    public void tradingNameEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Trading Name")){
                settingsGeneral.getEditButton().get(i).click();
                String tradingName = settingsGeneral.getTradingNameField().getAttribute("value");
                String tradingNameUpdate = "test trading name";
                settingsGeneral.getTradingNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), tradingNameUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), tradingNameUpdate);
                settingsGeneral.getEditButton().get(i).click();
                settingsGeneral.getTradingNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), tradingName);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void supportEmailEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Support Email")){
                settingsGeneral.getEditButton().get(i).click();
                String supportEmail = settingsGeneral.getSupportEmailField().getAttribute("value");
                String supportEmailUpdate = "test@test.com";
                settingsGeneral.getSupportEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), supportEmailUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), supportEmailUpdate);
                settingsGeneral.getEditButton().get(i).click();
                settingsGeneral.getSupportEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), supportEmail);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void billingEmailEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Billing Email")){
                settingsGeneral.getEditButton().get(i).click();
                String billingEmail = settingsGeneral.getBillingEmailField().getAttribute("value");
                String billingEmailUpdate = "test@test.com";
                settingsGeneral.getBillingEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), billingEmailUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), billingEmailUpdate);
                settingsGeneral.getEditButton().get(i).click();
                settingsGeneral.getBillingEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), billingEmail);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void supportPhoneNumberEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Support Phone Number")){
                settingsGeneral.getEditButton().get(i-1).click();
                String supportPhoneNumber = settingsGeneral.getSupportNumberField().getAttribute("value");
                String supportPhoneNumberUpdate = "+2348138904849";
                settingsGeneral.getSupportNumberField().sendKeys(Keys.chord(Keys.COMMAND, "a"), supportPhoneNumberUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), supportPhoneNumberUpdate);
                settingsGeneral.getEditButton().get(i-1).click();
                settingsGeneral.getSupportNumberField().sendKeys(Keys.chord(Keys.COMMAND, "a"), supportPhoneNumber);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void businessWebsiteEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Business Website Link")){
               settingsGeneral.getEditButton().get(i-1).click();
                String websiteLink = settingsGeneral.getBusinessWebsiteField().getAttribute("value");
                String websiteLinkUpdate = "https://test.com";
                settingsGeneral.getBusinessWebsiteField().sendKeys(Keys.chord(Keys.COMMAND, "a"), websiteLinkUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), websiteLinkUpdate);
                settingsGeneral.getEditButton().get(i-1).click();
                settingsGeneral.getBusinessWebsiteField().sendKeys(Keys.chord(Keys.COMMAND, "a"), websiteLink);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void privacyLinkEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Privacy Link")){
                settingsGeneral.getEditButton().get(i-2).click();
                String privacyLink = settingsGeneral.getPrivacyLinkField().getAttribute("value");
                String privacyLinkUpdate = "https://test.com";
                settingsGeneral.getPrivacyLinkField().sendKeys(Keys.chord(Keys.COMMAND, "a"), privacyLinkUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                if(packageName == "admin"){
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i-1).getText(), privacyLinkUpdate);
                }
                else{
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), privacyLinkUpdate);
                }
                settingsGeneral.getEditButton().get(i-2).click();
                settingsGeneral.getPrivacyLinkField().sendKeys(Keys.chord(Keys.COMMAND, "a"), privacyLink);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void termsOfServiceEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Terms of Service Link")){
                settingsGeneral.getEditButton().get(i-2).click();
                String termsOfService = settingsGeneral.getTermsOfServiceField().getAttribute("value");
                String termsOfServiceUpdate = "https://test.com";
                settingsGeneral.getTermsOfServiceField().sendKeys(Keys.chord(Keys.COMMAND, "a"), termsOfServiceUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(2000);
                if(packageName == "admin"){
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i-1).getText(), termsOfServiceUpdate);
                }
                else{
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), termsOfServiceUpdate);
                }
                settingsGeneral.getEditButton().get(i-2).click();
                settingsGeneral.getTermsOfServiceField().sendKeys(Keys.chord(Keys.COMMAND, "a"), termsOfService);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void contactNameEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Contact Name")){
                settingsGeneral.getEditButton().get(i-3).click();
                String firstName = settingsGeneral.getContactFirstNameField().getAttribute("value");
                String lastName = settingsGeneral.getContactLastNameField().getAttribute("value");
                String contactNameUpdate = "test";
                settingsGeneral.getContactFirstNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactNameUpdate);
                settingsGeneral.getContactLastNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactNameUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                if(packageName == "admin"){
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i-1).getText(), contactNameUpdate+ " "+ contactNameUpdate);
                }
                else{
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), contactNameUpdate+ " "+ contactNameUpdate);
                }
                settingsGeneral.getEditButton().get(i-3).click();
                settingsGeneral.getContactFirstNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), firstName);
                settingsGeneral.getContactLastNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), lastName);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void contactEmailEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Contact Email")){
                settingsGeneral.getEditButton().get(i-3).click();
                String contactEmail = settingsGeneral.getContactEmailField().getAttribute("value");
                String contactEmailUpdate = "test@test.com";
                settingsGeneral.getContactEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactEmailUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                if(packageName == "admin"){
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i-1).getText(), contactEmailUpdate);
                }
                else{
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), contactEmailUpdate);
                }
                settingsGeneral.getEditButton().get(i-3).click();
                settingsGeneral.getContactEmailField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactEmail);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    public void contactPhoneNumberEdit() throws InterruptedException {
        settingsGeneral =new SettingsGeneral();
        softAssert = new SoftAssert();
        for(int i=0; i<settingsGeneral.getInformationLabel().size(); i++){
            if(settingsGeneral.getInformationLabel().get(i).getText().equalsIgnoreCase("Contact Phone Number")){
                settingsGeneral.getEditButton().get(i-3).click();
                String contactPhoneNumber = settingsGeneral.getContactNumberField().getAttribute("value");
                String contactPhoneNumberUpdate = "+2348138904849";
                settingsGeneral.getContactNumberField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactPhoneNumberUpdate);
                settingsGeneral.getSaveButton().click();
                softAssert.assertEquals(getPopUpMessage().getText(), "Business updated successfully!");
                Thread.sleep(1500);
                if(packageName == "admin"){
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i-1).getText(), contactPhoneNumberUpdate);
                }
                else{
                    softAssert.assertEquals(settingsGeneral.getInfoTitle().get(i).getText(), contactPhoneNumberUpdate);
                }
                settingsGeneral.getEditButton().get(i-3).click();
                settingsGeneral.getContactNumberField().sendKeys(Keys.chord(Keys.COMMAND, "a"), contactPhoneNumber);
                settingsGeneral.getSaveButton().click();
                break;
            }
        }
        softAssert.assertAll();
        while(true){
            try{
                wait = new WebDriverWait(driver, durationInSeconds);
                wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
            }
            catch (Exception e){
                break;
            }
        }
    }

    public void validateApiWebHookPage(){
        sideMenu = new SideMenu();
        sideMenu.getSettings().click();
        settingsApiWebhook = new SettingsApiWebhook();
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", settingsApiWebhook.getWebhookTab());
        List<String> originalHeaderList = settingsApiWebhook.getPageHeader().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedHeader = {"API Keys", "Webhooks", "IP Whitelisting"};
        List<String> expectedHeaderList = Arrays.asList(expectedHeader);
        Assert.assertEquals(originalHeaderList, expectedHeaderList);
    }

    public void setApiKey(){
        settingsApiWebhook = new SettingsApiWebhook();
        settingsApiWebhook.getCreateApiKeyButton().click();
        settingsApiWebhook.getKeyNameField().sendKeys(apiKey);
        settingsApiWebhook.getKeyDescriptionField().sendKeys(description);
        settingsApiWebhook.getKeyCheckbox().stream().forEach(v->v.click());
        settingsApiWebhook.getSaveApiKeyButton().click();
        Assert.assertEquals(getPopUpMessage().getText(), "API Key created successfully!");
        settingsApiWebhook.getPopUpCloseButton().click();
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
    }

    public void validateApiKeyHeader(){
        settingsApiWebhook = new SettingsApiWebhook();
        List<String> originalHeaderList = settingsApiWebhook.getTableHeader().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedHeader = {"Name", "Description", "Environment", "Key Prefix", "Scopes", "Created At", "Actions"};
        List<String> expectedHeaderList = Arrays.asList(expectedHeader);
        Assert.assertEquals(originalHeaderList, expectedHeaderList);
    }

    public void editApiKey(){
        settingsApiWebhook = new SettingsApiWebhook();
        String apiKeyUpdate = apiKey +" update";
        String apiDescriptionUpdate = description +" update";
        for(int i=0; i<settingsApiWebhook.getKeyName().size(); i++){
            if(settingsApiWebhook.getKeyName().get(i).getText().equalsIgnoreCase(apiKey)){
                settingsApiWebhook.getKeyActionButton().get(i).click();
                settingsApiWebhook.getEditButton().click();
                settingsApiWebhook.getKeyNameField().sendKeys(Keys.chord(Keys.COMMAND, "a"), apiKeyUpdate);
                settingsApiWebhook.getKeyDescriptionField().sendKeys(Keys.chord(Keys.COMMAND, "a"), apiDescriptionUpdate);
                settingsApiWebhook.getUpdateButton().click();
                Assert.assertEquals(getPopUpMessage().getText(), "API Key updated successfully!");
                wait = new WebDriverWait(driver, durationInSeconds);
                wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
                break;
            }
            Assert.assertTrue(false);
            }

        apiKey = apiKeyUpdate;
    }

    public void deleteApiKey(){
        settingsApiWebhook = new SettingsApiWebhook();
        for(int i=0; i<settingsApiWebhook.getKeyName().size(); i++){
            if(settingsApiWebhook.getKeyName().get(i).getText().equalsIgnoreCase(apiKey)){
                settingsApiWebhook.getKeyActionButton().get(i).click();
                settingsApiWebhook.getDeleteButton().click();
                settingsApiWebhook.getDeleteConfirmationButton().click();
                Assert.assertEquals(getPopUpMessage().getText(), "API Key deleted successfully!");
                wait = new WebDriverWait(driver, durationInSeconds);
                wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
                break;
            }
            Assert.assertTrue(false);
        }
    }

    public void setIpAddress(){
        settingsApiWebhook = new SettingsApiWebhook();
        settingsApiWebhook.getAddIpAddressButton().click();
        settingsApiWebhook.getCurrentIpAddress().click();
        settingsApiWebhook.getIpCommentField().sendKeys(description);
        ipAddress = settingsApiWebhook.getIpAddressField().getAttribute("value");
        settingsApiWebhook.getSaveIpAddressButton().click();
        Assert.assertEquals(getPopUpMessage().getText(), "IP added successfully!");
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
    }

    public void validateIpAddressHeader(){
        settingsApiWebhook = new SettingsApiWebhook();
        List<String> originalHeaderList = settingsApiWebhook.getIpTableHeader().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedHeader = {"IP Address", "Status", "Comment", "Environment","Created At", "Actions"};
        List<String> expectedHeaderList = Arrays.asList(expectedHeader);
        Assert.assertEquals(originalHeaderList, expectedHeaderList);
    }

    public void editIpAddress(){
        settingsApiWebhook = new SettingsApiWebhook();
        String commentUpdate = description +" update";
        for(int i=0; i<settingsApiWebhook.getIpAddress().size(); i++){
            if(settingsApiWebhook.getIpAddress().get(i).getText().equalsIgnoreCase(ipAddress)){
                settingsApiWebhook.getIpActionButton().get(i).click();
                settingsApiWebhook.getEditButton().click();
                settingsApiWebhook.getIpAddressField().sendKeys(Keys.chord(Keys.COMMAND, "a"), "197.210.00.000");
                settingsApiWebhook.getIpCommentField().sendKeys(Keys.chord(Keys.COMMAND, "a"), commentUpdate);
                settingsApiWebhook.getUpdateButton().click();
                Assert.assertEquals(getPopUpMessage().getText(), "IP updated successfully!");
                wait = new WebDriverWait(driver, durationInSeconds);
                wait.until(ExpectedConditions.invisibilityOf(getPopUpMessage()));
                break;
            }
            Assert.assertTrue(false);
        }
    }

    public void deleteIpAddress(){
        settingsApiWebhook = new SettingsApiWebhook();
        for(int i=0; i<settingsApiWebhook.getIpAddress().size(); i++){
            if(settingsApiWebhook.getIpAddress().get(i).getText().equalsIgnoreCase("197.210.00.000")){
                settingsApiWebhook.getIpActionButton().get(i).click();
                settingsApiWebhook.getDeleteButton().click();
                settingsApiWebhook.getDeleteConfirmationButton().click();
                Assert.assertEquals(getPopUpMessage().getText(), "IP deleted successfully!");
                break;
            }
            Assert.assertTrue(false);
        }
    }

}


