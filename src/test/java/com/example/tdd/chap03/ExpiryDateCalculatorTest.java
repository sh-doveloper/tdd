package com.example.tdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부_한달_뒤_만료() {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();

        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10000;
        LocalDate expiryDate = calculator.calculateExpiryDate(billingDate, payAmount);

        LocalDate billingDate2 = LocalDate.of(2019, 5, 5);
        int payAmount2 = 10000;
        LocalDate expiryDate2 = calculator.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2019, 4, 1), expiryDate);
        assertEquals(LocalDate.of(2019, 6, 5), expiryDate2);
    }

}
