package com.example.tdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부_한달_뒤_만료() {
        assetExpiryDate(LocalDate.of(2019, 3, 1), 10000, LocalDate.of(2019, 4, 1));
        assetExpiryDate(LocalDate.of(2019, 5, 5), 10000, LocalDate.of(2019, 6, 5));
    }

    private void assetExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedDate) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate actualExpiryDate = calculator.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedDate, actualExpiryDate);
    }

}
