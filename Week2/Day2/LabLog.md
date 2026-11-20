# Week 2 Day 2: SmartStore Billing Lab Log

Project: SmartStoreBilling, package `com.smartstore.billing`
Files: `BillingApplication.java`, `BillingApplicationTest.java`

## Exercise 4: Refactoring (before and after)

Before output (original sample run, input: Rahul / Laptop Bag / 1200 / 5):

```
========== CUSTOMER BILL - SMARTSTORE ==========
Customer : Rahul
Product : Laptop Bag
Price : Rs. 1200.00
Quantity : 5
Total : Rs. 6000.00
Discount : 10%
Discount amount : Rs. 600.00
-----------------------------------------------
Final amount : Rs. 5400.00
===============================================
```

After output (refactored version, same input): identical to the block above.

Refactoring review:

| Question | Answer |
|---|---|
| New methods | `getDiscountPercent(double)` returns 0, 5 or 10. `calculateDiscount(double)` returns the rupee amount. `printBill(...)` prints the bill. |
| Parameters and return of `calculateDiscount()` | One `double totalAmount` parameter. Returns a `double` in rupees. |
| Did any threshold or comparison change? | No. The rules are `< 1000` (0%), `< 5000` (5%), otherwise 10%, which matches the case study. |
| Is before identical to after? | Yes, character for character. |
| Biggest readability gain | Splitting the discount rule into its own method, so the business rule sits in one place. |

## Exercise 5: Test execution sheet

| # | Price (Rs.) | Qty | Total (Rs.) | Expected discount | Expected discount amount | Expected final (Rs.) | Actual final (Rs.) | Pass? |
|---|---|---|---|---|---|---|---|---|
| 1 | 800 | 1 | 800 | 0% | 0.00 | 800.00 | 800.00 | Yes |
| 2 | 1000 | 1 | 1,000 | 5% | 50.00 | 950.00 | 950.00 | Yes |
| 3 | 4999 | 1 | 4,999 | 5% | 249.95 | 4,749.05 | 4,749.05 | Yes |
| 4 | 5000 | 1 | 5,000 | 10% | 500.00 | 4,500.00 | 4,500.00 | Yes |
| 5 | 7000 | 1 | 7,000 | 10% | 700.00 | 6,300.00 | 6,300.00 | Yes |
| 6 | 1200 | 5 | 6,000 | 10% | 600.00 | 5,400.00 | 5,400.00 | Yes |
| 7 | 999.99 | 1 | 999.99 | 0% | 0.00 | 999.99 | 999.99 | Yes |
| 8 | 250 | 4 | 1,000 | 5% | 50.00 | 950.00 | 950.00 | Yes |

Actual values come from running the program with each row's price and quantity. The "Actual" column was filled in from those runs.

Edge cases:

| Edge case | What happens now | What should happen |
|---|---|---|
| Total of Rs. 4,999.50 | Falls in the 5% band (it is below 5,000), so discount is Rs. 249.98 (rounded display). | Needs client confirmation. The written rule ("Rs. 1,000 to Rs. 4,999") leaves paise unclear. |
| Quantity 0 | Total is 0, bill shows 0% and Rs. 0.00. | Should be rejected with a clear message. |
| Negative price or quantity | Accepted without error. | Should be rejected with a clear message. |
| Text instead of a number for price | Program crashes with `InputMismatchException`. | Should re-prompt or show a friendly error. |

## Exercise 6: JUnit 5 tests

`BillingApplicationTest.java` contains five tests:

| Test | Input | Expected discount (Rs.) | Pass / fail |
|---|---|---|---|
| noDiscountBelowOneThousand | 800 | 0.00 | Expected to pass (same as program output above) |
| fivePercentDiscountAtExactlyOneThousand | 1000 | 50.00 | Expected to pass |
| fivePercentDiscountAtFourThousandNineHundredNinetyNine | 4999 | 249.95 | Expected to pass |
| tenPercentDiscountAtExactlyFiveThousand | 5000 | 500.00 | Expected to pass |
| tenPercentDiscountAboveFiveThousand | 7000 | 700.00 | Expected to pass |

These expected values match the program output in the Exercise 5 table. Run them in STS (Run As > JUnit Test) and record the real result here, since the JUnit jar was not available in this environment to run them.

## Exercise 7: Review findings (decide yourself)

Known weaknesses in this version:
- `double` is used for money. Amounts such as 4999.99 are not exact, so rounding can drift. Consider `BigDecimal` or storing paise as an integer.
- No validation for negative price or quantity, or for zero quantity.
- Non-numeric price input throws an exception instead of a friendly message.
- The rule for Rs. 4,999.50 needs confirmation from the client.
