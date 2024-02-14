Feature: User login

  Scenario: Successful login
    Given user opens beCognizant portal
    When user enters valid username
    And user enters valid password
    Then check if the home page of beCognizant is opening or not
    And user should see user account details
#	Scenario: Unsuccessful login
    #Given user opens beCognizant portal
    #When user entered valid username: ""
    #And user entered valid password: ""
    #Then check if the home page of beCognizant is opening or not
    #And user should see user account details
