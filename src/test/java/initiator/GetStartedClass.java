package initiator;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObject.element.FrontDesk;
import pageObject.element.GetStarted;
import pageObject.element.Identity;
import pageObject.element.SettingsGeneral;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetStartedClass extends LoginClass {

    GetStarted getStarted;

    SettingsGeneral settingsGeneral;

    SoftAssert softAssert;

    FrontDesk frontDesk;

    Identity identity;

    public void validateGetStartedPage() throws IOException {
        getStarted = new GetStarted();
        softAssert = new SoftAssert();
        softAssert.assertEquals(getStarted.getPageHeader().getText(), "Get Started");
        List<String> originalModalTitleList = getStarted.getModalTitle().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedModalTitleList = new String[0];
        if(packageName=="admin"){
             expectedModalTitleList = new String[]{"Start Dashboard Tour", "Manage Business", "Knowledge Base", "FAQs", "Create A New Verification Request."};

        } else if (packageName=="business") {
             expectedModalTitleList = new String[]{"Business Activation","Start Dashboard Tour", "Manage Business", "Knowledge Base", "FAQs", "Create A New Verification Request."};

        }
        List<String> expectedModalTitleListArray = Arrays.asList(expectedModalTitleList);
        softAssert.assertEquals(originalModalTitleList, expectedModalTitleListArray);
        softAssert.assertAll();
    }

    public void validateManageBusinessModule() {
        getStarted = new GetStarted();
        settingsGeneral = new SettingsGeneral();
        for(int q=0; q<getStarted.getModalTitle().size(); q++){
            if(getStarted.getModalTitle().get(q).getText().contains("Manage Business")){
                getStarted.getLetGoLink().get(q).click();
                break;
            }
        }
        Assert.assertTrue(settingsGeneral.getGeneralTab().isDisplayed());
    }

    public void validateKnowledgeBaseModule(){
        getStarted = new GetStarted();
        settingsGeneral = new SettingsGeneral();
        frontDesk = new FrontDesk();
        for(int q=0; q<getStarted.getModalTitle().size(); q++){
            if(getStarted.getModalTitle().get(q).getText().contains("Knowledge Base")){
                getStarted.getLetGoLink().get(q).click();
                break;
            }
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Assert.assertEquals(frontDesk.getPageHeader().getText(),"Getting Started with Youverify");
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void validateFaqModule(){
        getStarted = new GetStarted();
        settingsGeneral = new SettingsGeneral();
        frontDesk = new FrontDesk();
        for(int q=0; q<getStarted.getModalTitle().size(); q++){
            if(getStarted.getModalTitle().get(q).getText().contains("FAQs")){
                getStarted.getLetGoLink().get(q).click();
                break;
            }
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        Assert.assertTrue(frontDesk.getPageHeader().getText().contains("Frequently Asked Questions"));
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void validateVerificationRequestModule(){
        getStarted = new GetStarted();
        identity = new Identity();
        softAssert = new SoftAssert();
        getStarted.getLetGoButton().click();
        softAssert.assertTrue(identity.getIdentityCheckButton().isDisplayed());
        softAssert.assertEquals(identity.getPageHeader().getText(),"Identity");
        softAssert.assertAll();

    }

}
