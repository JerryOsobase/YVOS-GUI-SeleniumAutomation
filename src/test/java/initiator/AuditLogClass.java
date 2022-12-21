package initiator;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageObject.element.AuditLog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AuditLogClass extends LoginClass{

    SoftAssert softAssert;

    AuditLog auditLog;

    public void validateAuditLogPage(){
         softAssert = new SoftAssert();
        auditLog = new AuditLog();
        softAssert.assertTrue(auditLog.getFilterButton().isDisplayed());
        softAssert.assertEquals(auditLog.getPageHeader().getText(), "Audit Log");
        softAssert.assertAll();
    }

    public void validateListHeader(){
        auditLog = new AuditLog();
        List<String> originalList = auditLog.getActivitiesTableHeader().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedList = {"#", "Activity", "Time"};
        List<String> expectedListArray = Arrays.asList(expectedList);
        Assert.assertEquals(originalList, expectedListArray);
    }

    public void filterPopUpModule() throws InterruptedException {
        auditLog = new AuditLog();
        auditLog.getFilterButton().click();
        List<String> originalFilterOptions = auditLog.getFilterOptions().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedFilterOptions = {"Date", "Event", "Resource"};
        List<String> expectedFilterOptionsArray = Arrays.asList(expectedFilterOptions);
        Assert.assertEquals(originalFilterOptions, expectedFilterOptionsArray);
        try{
            auditLog.getPopUpCloseButton().click();
            wait = new WebDriverWait(driver, durationInSeconds);
            wait.until(ExpectedConditions.invisibilityOf(auditLog.getEventField()));
        }
        catch (Exception e){
            auditLog.getPopUpCloseButton().click();
            wait = new WebDriverWait(driver, durationInSeconds);
            wait.until(ExpectedConditions.invisibilityOf(auditLog.getEventField()));
        }


    }

    public void eventDropDownList() throws InterruptedException {
        auditLog = new AuditLog();
        auditLog.getFilterButton().click();
        auditLog.getEventField().click();
        List<String> originalEventDropDownOptions = auditLog.getDropDownList().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedEventDropDownOptions = {"All", "View", "Export", "Create", "Search", "Requery", "Generate", "Download",
                "Deactivate", "Activate", "ChangeRole", "AddUser", "AddMultipleUsers", "Manage", "Login", "Remove",
                "Update", "Verify", "Reconcile", "Request", "Credit", "Suspend", "Submit", "Start", "Publish"};
        List<String> eventDropDownOptionsArray = Arrays.asList(expectedEventDropDownOptions);
        Assert.assertEquals(originalEventDropDownOptions, eventDropDownOptionsArray);
        auditLog.getPopUpCloseButton().click();
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(auditLog.getEventField()));

    }

    public void resourceDropDownList() throws InterruptedException {
        auditLog = new AuditLog();
        auditLog.getFilterButton().click();
        auditLog.getResourceField().click();
        List<String> originalResourceDropDownOptions = auditLog.getDropDownList().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedResourceDropDownOptions = {"All", "Identity", "Address", "vForm", "AML", "CompanySearch", "CreditReport", "Certificate",
                "Business", "Organization", "User", "Auth", "Role", "Candidate", "Module", "Topic", "Quiz", "Feedback",
                "Faq", "Billing", "Agent", "Team", "Location", "QualityAssurance", "Analytics"};
        List<String> resourceDropDownOptionsArray = Arrays.asList(expectedResourceDropDownOptions);
        Assert.assertEquals(originalResourceDropDownOptions, resourceDropDownOptionsArray);
        auditLog.getPopUpCloseButton().click();
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(auditLog.getEventField()));
    }

    public void eventFilter(HashMap<String, String> data) throws InterruptedException {
        auditLog = new AuditLog();
        auditLog.getFilterButton().click();
        auditLog.getEventField().click();
        auditLog.getDropDownList().stream().filter(v->v.getText().equalsIgnoreCase(data.get("event"))).findAny().get().click();
        auditLog.getPopUpFilterButton();
        if(auditLog.getActivity().size()>=1){
            Thread.sleep(3000);
            long logSize = auditLog.getActivity().stream().count();
            long expectedLogSize = auditLog.getActivity().stream().filter(v->v.getText().toLowerCase().contains(data.get("event").toLowerCase())).count();
            Assert.assertEquals(logSize, expectedLogSize);
        }
        else{
            Assert.assertEquals(auditLog.getEmptyLogResult().getText(), "Nothing To Report Here");
        }

        auditLog.getClearButton().click();
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(auditLog.getClearButton()));
    }

    public void resourceFilter(HashMap<String, String> data) throws InterruptedException {
        auditLog = new AuditLog();
        auditLog.getFilterButton().click();
        auditLog.getResourceField().click();
        Thread.sleep(1500);
        auditLog.getDropDownList().stream().filter(v->v.getText().equalsIgnoreCase(data.get("resource"))).findAny().get().click();
        auditLog.getPopUpFilterButton();
        if(auditLog.getActivity().size()>=1){
            Thread.sleep(3000);
            long logSize = auditLog.getActivity().stream().count();
            long expectedLogSize = auditLog.getActivity().stream().filter(v->v.getText().toLowerCase().contains(data.get("resource").toLowerCase())).count();
            Assert.assertEquals(logSize, expectedLogSize);
        }
        else{
            Assert.assertEquals(auditLog.getEmptyLogResult().getText(), "Nothing To Report Here");
        }

        auditLog.getClearButton().click();
        wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(auditLog.getClearButton()));
    }

}
