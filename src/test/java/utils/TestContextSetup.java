package utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.TablesPage;
public class TestContextSetup {
	
	public WebDriver driver;
	public HomePage homePage;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public SeleniumHelper seleniumHelper;
	public TablesPage tablePage;

	
	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		homePage = new HomePage(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		seleniumHelper = new SeleniumHelper(testBase.WebDriverManager());
		tablePage = new TablesPage(testBase.WebDriverManager());
				
	}

}