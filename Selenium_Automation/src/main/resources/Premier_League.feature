@smoke
Feature: Premier League club names and positions collection and verification

Description: Users are able to collect and verify club names and positions

Scenario: Successful collection and verification of club names and positions

	Given User is able to open the Chrome browser
	Given Locate URL: https://www.premierleague.com/tables and press on Enter button
	When Users enter the table page
	Then Users are able to see the club names highlighted in red boxes
	Then Observe the total number of clubs
	Then Observe all the club names
	When Users highlight the club Chelsea
	Then Users are able to see Chelsea highlighted in blue box
	Then See Chelsea position is '6' highlighted in a blue box
	Then Take a screenshot of the page
	Then Close the browser