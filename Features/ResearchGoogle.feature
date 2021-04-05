Feature: GoogleResearch
  In order to find some sites on a subject, the user perform a research on Google

  Scenario: Research with one key word
    Given the user launch chrome browser
    Given the user is on the research Google page
    And the user enter a key word in the research field
    When the user validate
    Then the first site contains the key word
    And close browser