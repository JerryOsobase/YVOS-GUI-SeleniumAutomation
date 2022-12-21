package listeners;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class Parameters {


    @DataProvider
    public Object[][] validData(){
        Object[][] data = new Object [2][];
        Map<String, String> validData = Map.of("event","view", "resource", "address");
        Map<String, String> dp1 = new HashMap<>(validData);

        Map<String, String> validData1 = Map.of("event", "start", "resource", "vform");
        Map<String, String> dp2 = new HashMap<>(validData1);

        data[0] = new Object[] {dp1};
        data[1] = new Object[] {dp2};

        return data;

    }

    @DataProvider
    public Object[][] invalidData() {
        Object[][] data = new Object[2][];
        Map<String, String> invalidData = Map.of("invalidEmail", "jerry@youverify");
        Map<String, String> dp1 = new HashMap<>(invalidData);

        Map<String, String> invalidData1 = Map.of("invalidEmail", "jerryyouverify.co");
        Map<String, String> dp2 = new HashMap<>(invalidData1);

        data[0] = new Object[] {dp1};
        data[1] = new Object[] {dp2};
        return data;
    }

}
