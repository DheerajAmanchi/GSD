Feature: navigating to GSD page

  Scenario: verifying OneCognizant page is opening or not
    Given user is on beCognizant page
    When click on the oneCognizant
    Then verify oneCognizant page is opened

  Scenario: Opening GSD from OneCognizant portal
    When user enters value: "GSD" in search box
    And click on GSD app
    Then verify GSD page is opened
    And verify welcome message is displayed
    
	Scenario: verifying functionality of language and country dropdown
		When select the language: "english"
		And select the country available
		Then click on a random tile 
	
	Scenario: Count and store the listed query options and there tooltip
    When user checks for the presence of query options
    Then count the number of queries that are available on the gsd app
    And store the description in excel that appears when hovering over each query
	
		
	Scenario: Checking Ticket Status
  	When user clicks on ticket status
  	Then click on show all tickets
  	And count the number of tickets created
  	And navigate to gsd homepage
		