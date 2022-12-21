package business;

import initiator.SideMenuClass;
import initiator.testScenarios.sideMenu;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SideMenuTest extends SideMenuClass implements sideMenu {

    @BeforeClass
    public void initialize() throws IOException {
        InitializeBrowser();
        login();

    }

    @Test(priority = 1)
    @Override
    public void sideMenuListTest() throws IOException {
        getSideMenuList();
    }

    @AfterClass
    public void terminate(){
        driver.close();
    }
}
