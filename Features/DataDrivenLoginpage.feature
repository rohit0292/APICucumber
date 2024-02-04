Feature: Login function

  Scenario Outline: Successful Login with Valid entries
    Given user navigates to the website "https://www.amazon.in/" 
    When  user navigate to the login page
    And user enter Username in login window by using "<Email>"
    And User enter Password in login window by using "<password>"
    Then login must be successful.
    Then clik on Menubutton
    And  Page Title should be "Amazon"
    And  User click on Log out link
    
    
  Examples:
	|Email 	    | password    |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
