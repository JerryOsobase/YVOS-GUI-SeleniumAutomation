package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	public static WebDriver driver;
	public Properties prop;

	private static int timeOut = 10;
	public static Duration durationInSeconds = Duration.ofSeconds(timeOut);

	public static WebDriverWait wait;

	public String packageName = this.getClass().getPackageName();

	public static JavascriptExecutor executor;

	@SuppressWarnings("deprecation")
	public WebDriver InitializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//"
				+ "main//java//resources//data.properties");
		prop.load(fis);
		String BrowserName= prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			// TODO Auto-generated method stub
			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-ui-for-media-stream");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);

		}
		
		else if(BrowserName.equals("firefox")) {
			//execute firefox system properties
			
		}
		
		else if(BrowserName.equals("IE")) {
			//execute internet explorer system properties
		}

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		return null;
	}



	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String DestinationName= System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(DestinationName));
		return DestinationName;
	}


	}

