
Feature: Verify the Table feature functionalities

Background:
		Given User Login Into To Applicataion
 
		@Test_UXP-1120 @TablesPage @Regression @Medium @UI
  	Scenario: Verify All The Lables Present In Table HomePage
    Given User In Table Page
    Then Verify The All Lables Present In Table Page
    
    @Test_UXP-1121 @TablesPage @SmokeTest @Regression @Medium @UI
    Scenario: Verify Columns Header Of The Table Page
    Given User In Table Page
    Then Verify Columns Header Of The Table Page
    
    @Test_UXP-1122 @TablesPage @Regression @Sanity @Medium @UI
    Scenario: Verify Dropdown Options Of New Table
    Given User In Table Page
    Then Verify Dropdown Options Of New Table
    
    @Test_UXP-1123 @TablesPage @Regression @Medium @UI
    Scenario: Verify The Search Functionality In New Table
    Given User In Table Page
    Then Verify The Search Functionality In New Table
    
    @Test_UXP-1124 @TablesPage @Regression @Medium @UI
    Scenario: Verify The Labels Of Delete Table Popup
    Given User In Table Page
    Then Verify The Labels Of Delete Table Popup
    
    @Test_UXP-1125 @TablesPage @Regression @Medium @UI
    Scenario: Verify The Adding New Table Functionality
    Given User In Table Page
    Then Verify The Adding New Table Functionality
  