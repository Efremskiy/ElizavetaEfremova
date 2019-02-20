Feature: Different Elements Page Test

  Scenario: Main Interface Test
    Given I open EPAM JDI site
    Then Browser title should be 'Page_Title'
    And Home Page contains all needed elements

    When I login as user 'Piter_Chailovskii'
    Then User name should be 'Piter_Chailovskii'

    When I click on 'Service' subcategory in the header
    Then Header dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGE    |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I click on "Service" subcategory in the left section
    Then Left dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGE    |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I click on 'Different_Elements' in the header "Service" menu
    Then Different Elements Page contains all needed elements
    And There is right section
    And There is left section

    When I select elements:
      | WATER |
      | WIND  |
    Then Elements are marked as 'true' on logs:
      | WATER |
      | WIND  |

    When I select metal 'SELEN'
    Then Log is correct for metal 'SELEN'

    When I select color 'YELLOW'
    Then Log is correct for color 'YELLOW'

    When I select elements:
      | WATER |
      | WIND  |
    Then Elements are marked as 'false' on logs:
      | WATER |
      | WIND  |