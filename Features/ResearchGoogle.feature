Feature: GoogleResearch
  In order to find some sites on a subject, the user perform a research on Google

  Scenario: Research with one key word
    Given  the user is on the research Google page
    And the user enter a key word in the research field
    When the user validate
    Then a list of sites appears that contains the key word
    And a set of proposal containing the keyword appear at the bottom of the page