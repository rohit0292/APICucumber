 Feature: Login_function
 
 Scenario: Successful Login with Valid Credentials
       Given User Launch Chrome browsere
       When  User open URL "https://www.amazon.in/"
       And   User enter Email as "<Email>" and Password as "<password>"
       Then  Click on Login
       Then  Clik on Menubutton
       Then  Page Title should be "Amazon"
       When  User click on Log out link
       Then  Close browser
 Examples:
	|Email 	    | password    |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
	|9179482804 | Rohit@1992  |
	 