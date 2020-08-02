Feature: Login functionality

#Scenario: Test login with incorrect URL on browser
#Given Browser window is open on mobile
#When User hits login URL "https://the-internet.herok.com/login" 
#Then The "PageHeader" page should not be displayed

Scenario: Test login with correct URL on browser
Given Browser window is open on mobile
When User hits login URL "https://the-internet.herokuapp.com/login" 
Then The "PageHeader" page should be displayed


Scenario Outline: Test login functionality with invalid data 
Given "PageHeader" page is displayed
When User enters "<username>" in "UserName" text field
And User enters "<password>" in "Password" text field
And User taps "SubmitButton" Button
Then The "PageHeader" page should be displayed
Examples:
|username|password|
|user|password|
|user||
||password|
Scenario: Test login functionality with valid data 
Given "PageHeader" page is displayed
When User enters "tomsmith" in "UserName" text field
And User enters "SuperSecretPassword!" in "Password" text field
And User taps "SubmitButton" Button
Then The "SecureArea" page should be displayed
Then Close the browser