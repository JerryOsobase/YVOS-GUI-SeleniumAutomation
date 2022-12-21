package admin;

import initiator.AuditLogClass;
import initiator.testScenarios.auditLog;
import listeners.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.element.SideMenu;
import java.io.IOException;
import java.util.HashMap;


public class AuditLogTest extends AuditLogClass implements auditLog {

    SideMenu sideMenu;

    @BeforeClass
    public void initialize() throws IOException {
        InitializeBrowser();
        login();
        sideMenu = new SideMenu();
        sideMenu.getAuditLog().click();
    }

    @AfterClass
    public void terminate() {
         driver.close();
    }

    @Test(priority = 1)
    @Override
    public void validateAuditLogPageTest() {
        validateAuditLogPage();

    }

    @Test(priority = 2)
    @Override
    public void validateListHeaderTest() {
        validateListHeader();
    }

    @Test(priority = 3)
    @Override
    public void filterPopUpModuleTest() throws InterruptedException {
        filterPopUpModule();
    }


    @Test(priority = 4)
    @Override
    public void eventDropDownListTest() throws InterruptedException {
        eventDropDownList();
    }

    @Test(priority = 5, dataProvider = "validData", dataProviderClass = Parameters.class)
    @Override
    public void eventFilterTest(HashMap<String, String> data) throws InterruptedException {
        eventFilter(data);
    }

    @Test(priority = 6)
    @Override
    public void resourceDropDownListTest() throws InterruptedException {
        resourceDropDownList();
    }

    @Test(priority = 7, dataProvider = "validData", dataProviderClass = Parameters.class)
    @Override
    public void resourceFilterTest(HashMap<String, String> data) throws InterruptedException {
        resourceFilter(data);
    }

}
