package admin;

import initiator.GetStartedClass;
import initiator.testScenarios.getStarted;
import org.testng.annotations.*;
import pageObject.element.SideMenu;

import java.io.IOException;

public class GetStartedTest extends GetStartedClass implements getStarted {

    SideMenu sideMenu;
    @BeforeClass
    public void initialize() throws IOException {
        InitializeBrowser();
        login();
    }

    @BeforeMethod
    public void pageNavigation(){
        sideMenu = new SideMenu();
        sideMenu.getStarted().click();
    }

    @AfterClass
    public void terminate(){
        driver.close();
    }

    @Test(priority = 1)
    @Override
    public void validateGetStartedPageTest() throws IOException {
        validateGetStartedPage();
    }

    @Test(priority = 2)
    @Override
    public void validateManageBusinessModuleTest() {
        validateManageBusinessModule();
    }

    @Test(priority = 3)
    @Override
    public void validateKnowledgeBaseModuleTest() {
        validateKnowledgeBaseModule();
    }
    @Test(priority = 4)
    @Override
    public void validateFaqModuleTest() {
        validateFaqModule();
    }

    @Test(priority = 5)
    @Override
    public void validateVerificationRequestModuleTest() {
        validateVerificationRequestModule();
    }
}
