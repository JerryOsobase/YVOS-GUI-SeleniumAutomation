package business;

import initiator.AuditLogClass;
import initiator.SettingClass;
import initiator.testScenarios.settingApiWebHook;
import initiator.testScenarios.settingGeneral;
import initiator.testScenarios.settingProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SettingTest extends SettingClass implements settingProfile, settingGeneral, settingApiWebHook {

    AuditLogClass auditLogClass;

    @BeforeClass
    public void initialize() throws IOException {
        InitializeBrowser();
        login();
    }

    @AfterClass
    public void terminate() {
        driver.close();
    }

    @Test(priority = 1)
    @Override
    public void validateSettingsGeneralPageTest() {
        validateSettingsGeneralPage();
    }

    @Test(priority = 2, dependsOnMethods = "validateSettingsGeneralPageTest")
    @Override
    public void generalInformationTest() {
        generalInformation();
    }

    @Test(priority = 3)
    @Override
    public void tradingNameEditTest() throws InterruptedException {
        tradingNameEdit();
    }

    @Test(priority = 4)
    @Override
    public void supportEmailEditTest() throws InterruptedException {
        supportEmailEdit();
    }

    @Test(priority = 5)
    @Override
    public void billingEmailEditTest() throws InterruptedException {
        billingEmailEdit();
    }

    @Test(priority = 7)
    @Override
    public void supportPhoneNumberEditTest() throws InterruptedException {
        supportPhoneNumberEdit();
    }

    @Test(priority = 8)
    @Override
    public void businessWebsiteEditTest() throws InterruptedException {
        businessWebsiteEdit();
    }

    @Test(priority = 9)
    @Override
    public void privacyLinkEditTest() throws InterruptedException {
        privacyLinkEdit();
    }

    @Test(priority = 10)
    @Override
    public void termsOfServiceEditTest() throws InterruptedException {
        termsOfServiceEdit();
    }

    @Test(priority = 12)
    @Override
    public void contactNameEditTest() throws InterruptedException {
        contactNameEdit();
    }

    @Test(priority = 13)
    @Override
    public void contactEmailEditTest() throws InterruptedException {
        contactEmailEdit();
    }

    @Test(priority = 14)
    @Override
    public void contactPhoneNumberEditTest() throws InterruptedException {
        contactPhoneNumberEdit();
    }

    @Test(priority = 15)
    @Override
    public void validateSettingProfilePageTest() {
        validateSettingProfilePage();
    }

    @Test(priority = 16, dependsOnMethods = "validateSettingProfilePageTest")
    @Override
    public void userInformationTest() {
        userInformation();
    }

    @Test(priority = 17)
    @Override
    public void userInformationUpdateTest() throws InterruptedException {
        userInformationUpdate();
    }

    @Test(priority = 18)
    @Override
    public void validateApiWebHookPageTest() {
        validateApiWebHookPage();
    }

    @Test(priority = 19, dependsOnMethods = "validateApiWebHookPageTest")
    @Override
    public void setApiKeyTest() {
        setApiKey();
    }

    @Test(priority = 20)
    @Override
    public void validateApiKeyHeaderTest() {
        validateApiKeyHeader();
    }

    @Test(priority = 21, dependsOnMethods = "setApiKeyTest")
    @Override
    public void editApiKeyTest() {
        editApiKey();
    }

    @Test(priority = 22, dependsOnMethods = "editApiKeyTest")
    @Override
    public void deleteApiKeyTest() {
        deleteApiKey();
    }

    @Test(priority = 25)
    @Override
    public void setIpAddressTest() {
        setIpAddress();
    }

    @Test(priority = 26, dependsOnMethods = "setIpAddressTest")
    @Override
    public void validateIpAddressHeaderTest() {
        validateIpAddressHeader();
    }

    @Test(priority = 27, dependsOnMethods = "setIpAddressTest")
    @Override
    public void editIpAddressTest() {
        editIpAddress();
    }

    @Test(priority = 28, dependsOnMethods = "editIpAddressTest")
    @Override
    public void deleteIpAddressTest() {
        deleteIpAddress();
    }
}
