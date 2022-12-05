package business;

import initiator.LoginClass;
import initiator.testScenarios.login;
import listeners.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginTest extends LoginClass implements login {

	@BeforeClass
	public void initialize() throws IOException {
		driver= InitializeBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	@Override
	public void emptyEmailFieldTest() {
		emptyEmailField();
	}

	@Test(priority=2, dataProvider="invalidData", dataProviderClass= Parameters.class)
	@Override
	public void invalidEmailFormatTest(HashMap<String, String> data) {
		invalidEmailFormat(data);
	}

	@Test(priority=3)
	@Override
	public void invalidLoginTest() throws IOException {
		invalidLogin();
	}

	@Test(priority=4)
	@Override
	public void validLoginTest() throws IOException {
		validLogin();
	}

	@AfterClass
	public void terminate() {
		driver.close();
	}

}


