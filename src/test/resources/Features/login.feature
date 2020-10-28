@SmokeFeature
Feature: Feature to test login functionality
	
	@SmokeTest
  Scenario: Check login is succesful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page
  
  #Scenario + Outline para correr mas de un escenario con Examples
	#Scenario Outline: Check login is successful with valid credentials
		#Given user is on login page
		#When user enters <username> and <password>
		#And clicks on login button
		#Then user is navigated to home page
	
	#Examples para pruebas parametrizadas
	#Examples:
	#| username | password |
	#| user1 | pass1 |
	#| user2 | pass2 |
	