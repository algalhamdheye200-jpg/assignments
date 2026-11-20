package com.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Boundary tests for the SmartStore discount rules.
class BillingApplicationTest {

    @Test
    void noDiscountBelowOneThousand() {
        // 800 is under Rs. 1,000, so 0% discount
        assertEquals(0.00, BillingApplication.calculateDiscount(800.0), 0.001);
    }

    @Test
    void fivePercentDiscountAtExactlyOneThousand() {
        // exactly Rs. 1,000 starts the 5% band
        assertEquals(50.00, BillingApplication.calculateDiscount(1000.0), 0.001);
    }

    @Test
    void fivePercentDiscountAtFourThousandNineHundredNinetyNine() {
        // Rs. 4,999 is still in the 5% band
        assertEquals(249.95, BillingApplication.calculateDiscount(4999.0), 0.001);
    }

    @Test
    void tenPercentDiscountAtExactlyFiveThousand() {
        // exactly Rs. 5,000 starts the 10% band
        assertEquals(500.00, BillingApplication.calculateDiscount(5000.0), 0.001);
    }

    @Test
    void tenPercentDiscountAboveFiveThousand() {
        assertEquals(700.00, BillingApplication.calculateDiscount(7000.0), 0.001);
    }
}
