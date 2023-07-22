package opencart_TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class openCart_BaseTest {
	public static  WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass(groups= {"sanity"})
	@Parameters("browser")
	public void setup(String browsername) {
		rb = ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
		
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	
		driver.get(rb.getString("URL_app"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"sanity"})
	public void teardown() {
		driver.close();
	}

	public String randomaplha() {
		String generatedrandomaplha = RandomStringUtils.randomAlphabetic(7);
		return generatedrandomaplha;
	}
	
	public String captureScreenshot(String testmethodname) {
		
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String destination = System.getProperty("user.dir")+ "\\Screenshots\\" + testmethodname + "_" + timestamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
		
	}

}
