Feature: Login function

  Scenario: Successful Login with Valid entries
    Given user navigates to the website "https://www.amazon.in/"
    When user navigate to the login page
    And user enter Username in login window by using <Email> as "9179482804"
    And User enter Password in login window by using <password> as "Rohit@1992"
    Then login must be successful.
    Then clik on Menubutton
    And Page Title should be "Amazon"
    And User click on Log out link

  @smoke
  Scenario: Verify skills features on Alexa skills page
    Given User navigate to All menu button
    Then click on Echo & Alexa farward arrow
    And click on Alexa skills page
    Then Capture all feature with text.
    Then Close browser
