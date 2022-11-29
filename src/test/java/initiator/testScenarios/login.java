package initiator.testScenarios;

import listeners.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public interface login {

    public void emptyEmailFieldTest();

    public void invalidEmailFormatTest(HashMap<String, String> data);

    public void invalidLoginTest() throws IOException;

    public void validLoginTest() throws IOException;





}
