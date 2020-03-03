Feature: GCP Test Automation


  @FirstTag
  Scenario: Launch GCP
    Given I launch chrome
    And I navigate to the Google Cloud Platform Home Page
    Then I close the driver