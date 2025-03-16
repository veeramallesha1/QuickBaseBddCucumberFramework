package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		prop.load(fis);

		String url = PropertyHelper.getGlobalPropertyValue("QAUrl");
		String browser_Properties = prop.getProperty("browser");
		String browser_Maven = System.getProperty("browser");
		String browser = browser_Maven != null ? browser_Maven : browser_Properties;

		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);

		}
		return driver;
	}

}