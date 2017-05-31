Feature: Shopping Basket Scenario

  Scenario Outline: shopping basket has 1 item added
    Given The shopping basket has <QUANTITY> of <PRODUCT>
    When I calculate the final price
    Then The price should show <FINAL_PRICE>

  Examples:
  |PRODUCT | QUANTITY | FINAL_PRICE |
  |BEANS   | 1        | 0.50        |
  |ORANGE  | 0.200    | 0.40        |
  |COKE    | 1        | 0.70        |

 