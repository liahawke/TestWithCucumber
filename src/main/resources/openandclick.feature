Feature: Customer uses site
         As a Customer,
         I want to open site
         and use links
Scenario: Use Python and Home Links
          Given The user opens site sees Home Page
          When He clicks Python link sees Python page
          When He verify title on Python Page
          Then Title is 'Selenium Framework | Python Course'
          When He clicks Home link
          Then User closes browser