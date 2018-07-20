@smoke
Feature: Premier League club names and positions collection and verification

Description: Users are able to collect and verify club names and positions

Scenario: Successful collection and verification of club names and positions

	Given User is able to open the Chrome browser
	And Locate URL: https://www.premierleague.com/tables and press on Enter button
	When Users enter the table page
	Then Users are able to see the club names highlighted in red boxes
	And Observe the total number of clubs
	And Observe all the club names
	When Users highlight the club Chelsea
	Then Users are able to see Chelsea highlighted in blue box
	And See Chelsea position is '6' highlighted in a blue box
	And Take a screenshot of the page
	And Close the bowser