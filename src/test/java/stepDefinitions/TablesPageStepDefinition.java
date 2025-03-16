package stepDefinitions;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.TablesPage;
import utils.TestContextSetup;

public class TablesPageStepDefinition {
	
	public WebDriver driver;
	TestContextSetup textContextSetup;
	HomePage homePage;
	TablesPage tablesPage;
	HashMap<String, Boolean> results = new HashMap<String, Boolean>();

	public TablesPageStepDefinition(TestContextSetup textContextSetup) {
		
		this.textContextSetup = textContextSetup;
	}
	
	@Given("^User Login Into To Applicataion$")
	public void userLoginIntoToApplicataion() throws Exception {
		tablesPage = textContextSetup.homePage.getTablesPage();
		tablesPage.userLoginIntoToApplicataion();	
		
	}
	
	@Given("^User In Table Page$")
	public void userInTablePage() throws Exception {
		tablesPage = textContextSetup.homePage.getTablesPage();
		tablesPage.userInTablePage();	
		
	}
	@Then("^Verify The All Lables Present In Table Page$")
	public void verifyTheAllLablesPresentITablePage() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyTheAllLablesPresentITablePage();	
		assertThat(results.containsValue(false), is(false));
		
	}
	@Then("^Verify Columns Header Of The Table Page$")
	public void verifyColumnsHeaderOfTheTablePage() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyColumnsHeaderOfTheTablePage();	
		assertThat(results.containsValue(false), is(false));
		
	}
	
	@Then("^Verify Dropdown Options Of New Table$")
	public void verifyDropdownOptionsOfNewTable() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyDropdownOptionsOfNewTable();	
		assertThat(results.containsValue(false), is(false));
		
	}
	
	@Then("^Verify The Search Functionality In New Table$")
	public void verifyTheSearchFunctionalityInNewTable() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyTheSearchFunctionalityInNewTable();	
		assertThat(results.containsValue(false), is(false));
		
	}
	
	@Then("^Verify The Labels Of Delete Table Popup$")
	public void verifyTheLabelsOfDeleteTablePopup() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyTheLabelsOfDeleteTablePopup();	
		assertThat(results.containsValue(false), is(false));
		
	}
	
	@Then("^Verify The Adding New Table Functionality$")
	public void verifyTheAddingNewTableFunctionality() throws Exception {
		tablesPage= textContextSetup.homePage.getTablesPage();
		results = tablesPage.verifyTheAddingNewTableFunctionality();	
		assertThat(results.containsValue(false), is(false));
		
	}
	
}
