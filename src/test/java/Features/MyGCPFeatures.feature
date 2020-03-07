Feature: Assess whether we get a resposne from BigQuery

  Scenario: Establish a connection with BigQuery and check the response
    Given I set the GCP credentials
    And I query the Waste and Diversion Dataset from "local"