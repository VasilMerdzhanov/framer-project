Feature: Validate the Framer Website

  Background: The Framer site is loaded
    Given the Framer site is loaded
  
    Scenario: Does display products' currency symbol as '$' in the 'Pricing' page
    When I click on 'Pricing' button
    And I see the Pricing page
    Then I see the products' currency symbol is displayed as '$' in the 'Pricing' page  
    
  Scenario: Does contain 4 questions in the FAQ section from 'Pricing' page
    When I click on 'Pricing' button
    And I see the Pricing page
    Then I see the FAQ section contains 4 questions

  Scenario: Does display 'visit' button on each card in the 'Many types of components to customize' section
    And I scroll to 'Many types of components to customize' in the components page
    Then I see the 'visit' button is displayed on each card in the 'Many types of components to customize' section

  Scenario: Does display the 'Updates' page after clicking the 'Update' button
    And I see the 'Updates' button
    When I click on the 'Updates' button
    Then I see the Updates page is displayed

  Scenario: Does display 'get the app' and 'watch video' one above the other on mobile
    Given the Framer site is loaded on mobile
    Then I see the 'get the app' and 'watch video' buttons are displayed one above the other on mobile
    
