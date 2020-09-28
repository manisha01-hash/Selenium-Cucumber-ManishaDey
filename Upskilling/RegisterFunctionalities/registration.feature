Feature: Resgister with signup option in Upskill Application

  Scenario: Validate signing up done successfully
    Given I am able to navigate onto Signin page
    Given User enters "tanisha" and "Dey"
    * User enters "manisha1dey@gmail.com" and "manisha2.dey" and "Nora$123"
    * User provide the "Nora$123" for confirmation
    * I click on the login button
    Then I should see the username as "Manisha.dey"


  Scenario: User exists already
    Given I am able to navigate onto Signin page
    Given User enters "Manisha" and "Dey"
    * User enters "manisha1dey@gmail.com" and "manisha.dey" and "Doremon$123"
    * User provide the "Doremon$123" for confirmation
    * I click on the login button
    Then I should see the username already exists
     
    
 Scenario: If the user already exists, login with appropiate credentials
 	Given User has already the existing account
 	And Enter the Username and password
 	And click on the login button
 	Then User will be moved to Home page
 	
 	  Scenario: validate the Email
    Given click on the login_icon
    And Click on inbox and select compose message
    And select the send to id
    And Write the subject of the email
    And the message needs to be sent
    Then click on send 
    
