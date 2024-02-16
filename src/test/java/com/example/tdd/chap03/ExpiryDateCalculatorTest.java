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

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assetExpiryDate(LocalDate.of(2019, 1, 31), 10000, LocalDate.of(2019, 2, 28));
        assetExpiryDate(LocalDate.of(2019, 5, 31), 10000, LocalDate.of(2019, 6, 30));
        assetExpiryDate(LocalDate.of(2020, 1, 31), 10000, LocalDate.of(2020, 2, 29));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assetExpiryDate(LocalDate.of(2019, 1, 31), 10000, LocalDate.of(2019, 2, 28));
        assetExpiryDate(LocalDate.of(2019, 5, 31), 10000, LocalDate.of(2019, 6, 30));
        assetExpiryDate(LocalDate.of(2020, 1, 31), 10000, LocalDate.of(2020, 2, 29));
    }


}
