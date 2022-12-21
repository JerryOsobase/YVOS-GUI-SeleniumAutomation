package initiator.testScenarios;

import java.util.HashMap;

public interface auditLog {

    public void validateAuditLogPageTest();

    public void validateListHeaderTest();

    public void filterPopUpModuleTest() throws InterruptedException;

    public void eventDropDownListTest() throws InterruptedException;

    public void eventFilterTest(HashMap<String, String> data) throws InterruptedException;

    public void resourceDropDownListTest() throws InterruptedException;

    public void resourceFilterTest(HashMap<String, String> data) throws InterruptedException;

}
