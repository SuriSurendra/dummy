Feature: Registration

  Scenario: Successful navigation to account page
    Given I navigate to the home page
    When I click on Join
    Then I should be on the account page

  Scenario: Successful entry of valid account details
    When I enter email address
    And I enter username
    And I enter password
    And I click on Terms and Conditions checkbox
    And I click Continue
    Then I should be redirected to Personal page

  Scenario: Successful entry of valid personal details
    When I select title
    And I enter first name
    And I enter last name
    And I enter date of birth
    And I click Continue
    Then I should be redirected to Contact page

  Scenario: Success entry of valid contact details
    When I enter phone number
    And I select a security question
    And I enter an answer
    And I click on Continue
    Then I should be directed to Address page

  Scenario: Successful entry of valid address details
    When I enter address or postcode
    And I click on dropdown to select address
    And I click on Continue
    Then I should be redirected to Settings page

  Scenario: Successful setting of preferences
    When I click on email checkbox
    And I click Continue
    Then I should see a greeting message for successful registration