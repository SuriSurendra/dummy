Feature: Front-end Home Page Scenarios

Scenario: Successfully validate the response
	Given User Launch Chrome browser
	When User opens URL "http://affiliate-feed.petfre.sgp.bet/1/health"
	Then user should validate the response
	And user close the browser

	Scenario: Successfully validate the countries
		Given User Launch Chrome browser
		When User opens URL "http://affiliate-feed.petfre.sgp.bet/1/countries?languageCode=en"
		And I should add <language> as a parameter
		Then user should validate the countries retrieved
		And user close the browser
		|language|
		|english |
		|french  |
