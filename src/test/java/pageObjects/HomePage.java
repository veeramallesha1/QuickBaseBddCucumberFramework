package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public TablesPage tablesPage;
	public WebDriver driver;
	
	public static String pageName;
	public static Map<String, String> resourceMap = null;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public TablesPage getTablesPage() {
		
		return tablesPage = new TablesPage(driver);
	}
	
	
}