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

  Scenario Outline: shopping basket has multiple products with NO DISCOUNT
    Given The shopping basket has multiple products <PRODUCT1> <QUANTITY1> <PRODUCT2> <QUANTITY2>
    When I calculate the final price
    Then The price should show <FINAL_PRICE>
  Examples:
    |PRODUCT1 | QUANTITY1 |PRODUCT2 | QUANTITY2 |FINAL_PRICE |
    |BEANS    | 2         |ORANGE   | 0.200     | 1.40       |



  Scenario Outline: shopping basket has multiple products with DISCOUNT
    Given The shopping basket has multiple products <PRODUCT1> <QUANTITY1> <PRODUCT2> <QUANTITY2>
    When I calculate the final price with discount
    Then The price should show <FINAL_PRICE>
  Examples:
    |PRODUCT1 | QUANTITY1 |PRODUCT2 | QUANTITY2 |FINAL_PRICE |
    |BEANS    | 3         |COKE     | 2         |2          |