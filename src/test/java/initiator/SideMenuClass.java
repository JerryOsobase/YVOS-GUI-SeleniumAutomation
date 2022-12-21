package initiator;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObject.element.SideMenu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SideMenuClass extends LoginClass {

    SideMenu sideMenu;
    public void getSideMenuList() throws IOException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        sideMenu = new SideMenu();
        executor.executeScript("arguments[0].click();", sideMenu.getSdk());
        executor.executeScript("arguments[0].click();", sideMenu.getVerification());
        List<String> originalSideMenuList = sideMenu.getSideMenuList().stream().map(v->v.getText()).collect(Collectors.toList());
        String[] expectedSideMenuList = new String[0];
        if(packageName == "admin"){
             expectedSideMenuList = new String[]{"Get Started", "Overview\n" + "Coming soon", "vForms", "SDK", "Liveness Check",
                     "Document Capture", "Verification", "Identity", "Address", "Company Check", "AML",
                     "Certificate\n" + "Coming soon", "Businesses", "Billing", "Users", "Audit Log", "Settings"};
        } else if (packageName == "business") {
            expectedSideMenuList = new String[]{"Get Started", "Overview\n" + "Coming soon", "vForms", "SDK", "Liveness Check",
                    "Document Capture", "Verification", "Identity", "Address", "Company Check", "AML",
                    "Certificate\n" + "Coming soon", "Organizations", "Billing", "Users", "Audit Log", "Settings"};
        }
        List<String> expectedSideMenuListArray = Arrays.asList(expectedSideMenuList);
        Assert.assertEquals(originalSideMenuList,expectedSideMenuListArray);
    }
}
