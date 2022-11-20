package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.fetch.model.AuthChallengeResponse;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	
	public ChromeDriver driver;
	public Properties prop;

	@SuppressWarnings("deprecation")
	public ChromeDriver InitializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//"
				+ "main//java//resources//data.properties");
		prop.load(fis);
		String BrowserName= prop.getProperty("browser");
		System.out.println(BrowserName);
		if(BrowserName.equals("chrome")) {
			// TODO Auto-generated method stub
			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-ui-for-media-stream");
			System.setProperty("webdriver.chrome.driver", "//Users//jerryosobase//Applications//chromedriver");
			driver=new ChromeDriver(options);
			DevTools devTools = driver.getDevTools();
			devTools.createSession();


			devTools.send(Network.enable(Optional.empty(),Optional.empty(), Optional.empty()));
			final RequestId[] id = new RequestId[1];


			devTools.addListener(Network.responseReceived(), response->{
				Response res = response.getResponse();
				if(res.getUrl().contains("api/v1/user/verify")){
				if(res.getStatus().equals(200)){
						id[0] = response.getRequestId();
						String responseBody = devTools.send(Network.getResponseBody(id[0])).getBody().toString();
						System.out.println(res.getStatus()+" "+ res.getUrl());
						String[] split = responseBody.split("\"code\":");
						String[] split1 = split[1].split("}");
						String[] split2 = split1[0].split("\"");
						String verificationCode = split2[1].trim();
					System.out.println(verificationCode);
					prop.setProperty("token", verificationCode);
					}

				}
			});
		}
		
		else if(BrowserName.equals("firefox")) {
			//execute firefox system properties
			
		}
		
		else if(BrowserName.equals("IE")) {
			//execute internet explorer system properties
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
			
	}



	public String getScreenshot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String DestinationName= System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
		FileUtils.copyFile(source, new File(DestinationName));
		return DestinationName;
	}


	}

