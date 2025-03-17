package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PropertyHelper;
import utils.SeleniumHelper;

public class TablesPage {


	@FindBy(id = "quickbaseSignin")
	public WebElement btnNo;

	@FindBy(css = "#loginMsgDiv")
	public WebElement lblSignMsg;

	@FindBy(xpath = "//input[@type='text' and @name='loginid']")
	public WebElement txtUserName;

	@FindBy(xpath = "//input[@type='password' and @name='password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit' and @id='signin']")
	public WebElement btnSignIn;

	@FindBy(id = "RememberDevice")
	public WebElement chkRememberMe;
	
	@FindBy(css = "p.iconWithTextMainText")
	public WebElement icnProjectSelection;
	
	@FindBy(xpath = "//div[contains(text(),'App settings')]")
	public WebElement lblAppSetting;
	
	@FindBy(xpath = "//a[contains(text(),'Tables')]")
	public WebElement lnkTables;
	
	@FindBy(css = "span.Text")
	public WebElement lblNewTableCreate;

	@FindBy(css = "div.AlertMessageDiv")
	public WebElement txtAlertMsg;

	@FindBy(id = "tablesSearch")
	public WebElement txtSearchTable;

	@FindBy(id = "appTablesListToolbar")
	public WebElement lblTableBox;
	
	@FindBy(id = "appTablesListTable_label")
	public WebElement lblTable;
	
	@FindBy(id = "appTablesListTable_numFields")
	public WebElement lblFields;
	
	@FindBy(id = "appTablesListTable_relNames")
	public WebElement lblRelatedTo;
	
	@FindBy(xpath = "//div[@id='tableFromscratch' and @class='fromscratch']")
	public List<WebElement> lblFromScratch;
	
	@FindBy(xpath = "//div[@id='tableFromDataConn' and @class='fromDataConn']")
	public List<WebElement> lblUsingConnected;
	
	@FindBy(xpath ="//a[@data-tipped='next']")
	public WebElement lnkTableName;
	
	@FindBy(xpath ="//a[@class='RowAction Delete Icon']")
	public WebElement icnDeleteTable;
	
	@FindBy(css ="#typeYesField")
	public WebElement txtDeleteMsg;
	
	@FindBy(css ="#dialogDeleteTable button")
	public List<WebElement> deletePopButtons;
	
	@FindBy(css ="span.ui-dialog-title")
	public WebElement lblDeletePopHeader;
	
	@FindBy(css ="#delete-table-dialog")
	public WebElement lblDeleteMsg1;
	
	@FindBy(css ="span.DeleteWarningText")
	public WebElement lblDeleteMsg2;
	
	@FindBy(css ="#confirmDeleteEntryText")
	public WebElement lblDeleteMsg3;
	
	@FindBy(css ="span.ui-button-icon-space")
	public WebElement icnClose;
	
	@FindBy(xpath ="//input[@aria-label='Table name']")
	public WebElement txtTableName;
	
	@FindBy(xpath ="//input[@data-test-id='SingleRecordInput']")
	public WebElement txtSingleRecord;
	
	@FindBy(xpath ="//button[@data-test-id='dialogOkButton']")
	public WebElement btnCreateTable;
	
	@FindBy(xpath ="//button[@data-test-id='dialogCancelButton']")
	public WebElement btnCancel;
	
	@FindBy(css ="span.ResponsiveText")
	public WebElement ddSettings;

	private WebDriver driver;
	HashMap<String, Boolean> results = new HashMap<String, Boolean>();
	public static Map<String, String> resourceMap = null;
	private String pageName;
	private SeleniumHelper seleniumHelper;

	public TablesPage(WebDriver driver) {
		this.driver = driver;
		this.seleniumHelper = new SeleniumHelper(driver);
		this.pageName = "TablesPage";
		this.resourceMap = PropertyHelper.loadResourcefile(driver.getCurrentUrl(), pageName);
		PageFactory.initElements(driver, this);

	}
	
	/***
	 * User Will Login Into Application
	 * @author Veeramallesha CN
	 * @return void
	 * @throws Exception
	 ***/
	public void userLoginIntoToApplicataion() throws Exception {
		seleniumHelper.click(btnNo);
		seleniumHelper.click(lblSignMsg);
		seleniumHelper.sendKeysTo(txtUserName, PropertyHelper.getGlobalPropertyValue("userName"));
		seleniumHelper.sendKeysTo(txtPassword, PropertyHelper.getGlobalPropertyValue("password"));
		seleniumHelper.click(btnSignIn);
		seleniumHelper.sleepWait(15);
		seleniumHelper.click(chkRememberMe);
		seleniumHelper.click(btnSignIn);
		seleniumHelper.sleepWait(3);
	}
	
	/***
	 * User Will Navigate To Tables Page
	 * @author Veeramallesha CN
	 * @return void
	 * @throws Exception
	 ***/
	public void userInTablePage() throws Exception {
		seleniumHelper.click(icnProjectSelection);
		seleniumHelper.click(lblAppSetting);
		seleniumHelper.sleepWait(1);
		seleniumHelper.click(lnkTables);
	}
	
	/***
	 * Verify The All Lables Present In TablePage
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyTheAllLablesPresentInTablePage() throws Exception {
		Map<String, String> dataMap = PropertyHelper.readTestDataJson("UXP-1121");
		seleniumHelper.click(lblTableBox);
		String newTable = lblNewTableCreate.getText().trim();
		String alertMsg = txtAlertMsg.getText().trim();
		String searchBox = txtSearchTable.getDomAttribute("placeholder");
		results.put("NewTableIcon", newTable.equalsIgnoreCase(resourceMap.get("newTable")));
		results.put("AlertMessage", alertMsg.equalsIgnoreCase(resourceMap.get("alertMsg")));
		results.put("SerchBox", searchBox.equalsIgnoreCase(resourceMap.get("searchTables")));
		return results;
	}
	
	/***
	 * Verify Columns Header Of The TablePage
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyColumnsHeaderOfTheTablePage() throws Exception {
		Map<String, String> dataMap = PropertyHelper.readTestDataJson("UXP-1121");
		ArrayList<String> actualColumnsNames = new ArrayList<String>();
		actualColumnsNames.add(lblTable.getText().trim());
		actualColumnsNames.add(lblFields.getText().trim());
		actualColumnsNames.add(lblRelatedTo.getText().trim());
		List<String> expectedColumnsNames = Arrays.asList(dataMap.get("tablesColumnsNames").split(","));
		results.put("ColumnsNames", actualColumnsNames.equals(expectedColumnsNames));
		return results;
	}
		
	/***
	 * Verify Dropdown Options Of NewTable Page
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyDropdownOptionsOfNewTable() throws Exception {
		seleniumHelper.sleepWait(3);
		seleniumHelper.click(txtAlertMsg);
		seleniumHelper.click(lblNewTableCreate);
		seleniumHelper.sleepWait(2);
		String[] fromScrath = lblFromScratch.get(1).getText().split("\\n");
		String[] usingConnected = lblUsingConnected.get(1).getText().split("\\n");
		results.put("FromScratch", fromScrath[0].equalsIgnoreCase(resourceMap.get("fromScratch")));
		results.put("DesignYourTable", fromScrath[1].equalsIgnoreCase(resourceMap.get("designYourOwnTable")));
		results.put("UsingConnected", usingConnected[0].equalsIgnoreCase(resourceMap.get("usingConnected")));
		results.put("Connected", usingConnected[1].equalsIgnoreCase(resourceMap.get("connected")));
		return results;
	}
	
	/***
	 * Verify The Search Functionality In NewTable Page
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyTheSearchFunctionalityInNewTable() throws Exception {
		String tableName=resourceMap.get("tableName");	
		seleniumHelper.sleepWait(3);
		seleniumHelper.click(txtAlertMsg);
		seleniumHelper.sendKeysTo(txtSearchTable, tableName);
		seleniumHelper.sleepWait(1);
		String actualTable = lnkTableName.getText();
		results.put("TableSearch", tableName.equalsIgnoreCase(actualTable));
		return results;
	}
	
	/***
	 * Verify The Labels Of Delete Table Popup
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyTheLabelsOfDeleteTablePopup() throws Exception {
		Map<String, String> dataMap = PropertyHelper.readTestDataJson("UXP-1124");
		System.out.println(dataMap);
		seleniumHelper.sleepWait(3);
		seleniumHelper.click(txtAlertMsg);
		seleniumHelper.click(icnDeleteTable);
		seleniumHelper.sleepWait(2);		
		results.put("DeleteHeader",lblDeletePopHeader.getText().trim().equalsIgnoreCase(dataMap.get("deleteThisTable?")));
		results.put("CloseIcon",deletePopButtons.get(0).isDisplayed());
		results.put("DeleteTable",deletePopButtons.get(1).getText().trim().equalsIgnoreCase(dataMap.get("deleteTable")));
		results.put("Cancel",deletePopButtons.get(2).getText().trim().equalsIgnoreCase(dataMap.get("cancel")));
		List<String> list1 = new ArrayList<String>();
		String[] s= lblDeleteMsg1.getText().trim().split("\\n");
		for(int i=0; i<s.length; i++) {
			list1.add(s[i].trim());
		}
		List<String> uIValues = new ArrayList<String>();
		for(int i=0; i<list1.size(); i++) {
			if(list1.get(i).length() > 0) {
				uIValues.add(list1.get(i));
			}
		}
		results.put("DeleteMsg1",uIValues.get(0).equalsIgnoreCase(dataMap.get("deleteMsg1")));
		results.put("DeleteMsg2",uIValues.get(1).equalsIgnoreCase(dataMap.get("deleteMsg2")));
		results.put("DeleteMsg3",uIValues.get(2).equalsIgnoreCase(dataMap.get("deleteMsg3")));
		results.put("DeleteMsgBox", txtDeleteMsg.isDisplayed());
		seleniumHelper.click(icnClose);
		return results;
	}
	
	/***
	 * Verify The Adding NewTable Functionality
	 * @author Veeramallesha CN
	 * @return HashMap<String, Boolean>
	 * @throws Exception
	 ***/
	public HashMap<String, Boolean> verifyTheAddingNewTableFunctionality() throws Exception {
		seleniumHelper.sleepWait(3);
		String s = "Table2";
		seleniumHelper.click(lblNewTableCreate);
		seleniumHelper.click(lblFromScratch.get(1));
		seleniumHelper.sendKeysTo(txtTableName, s);
		seleniumHelper.sendKeysTo(txtSingleRecord, "Testing");
		seleniumHelper.click(btnCreateTable);
		seleniumHelper.click(btnCancel);
		Thread.sleep(2000);
		results.put("NewTableName",ddSettings.getText().contains(s));
		return results;
	}

}