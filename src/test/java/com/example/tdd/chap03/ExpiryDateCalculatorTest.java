package com.example.tdd.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부_한달_뒤_만료() {
        assetExpiryDate(
            PayData.builder()
                .billingDate(LocalDate.of(2019, 3, 1))
                .payAmount(10000).build()
            , LocalDate.of(2019, 4, 1));

        assetExpiryDate(
            PayData.builder()
                .billingDate(LocalDate.of(2019, 5, 5))
                .payAmount(10000).build()
            , LocalDate.of(2019, 6, 5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assetExpiryDate(
            PayData.builder()
                .billingDate(LocalDate.of(2019, 1, 31))
                .payAmount(10000).build()
            , LocalDate.of(2019, 2, 28));
        assetExpiryDate(
            PayData.builder()
                .billingDate(LocalDate.of(2019, 5, 31))
                .payAmount(10000).build()
            , LocalDate.of(2019, 6, 30));
        assetExpiryDate(
            PayData.builder()
                .billingDate(LocalDate.of(2020, 1, 31))
                .payAmount(10000).build()
            , LocalDate.of(2020, 2, 29));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        assetExpiryDate(
            PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build(), LocalDate.of(2019, 3, 31)
        );
        assetExpiryDate(
            PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 30))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10000)
                .build(), LocalDate.of(2019, 3, 30)
        );
        assetExpiryDate(
            PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 5, 31))
                .billingDate(LocalDate.of(2019, 6, 30))
                .payAmount(10000)
                .build(), LocalDate.of(2019, 7, 31)
        );
    }

    private void assetExpiryDate(PayData payData, LocalDate expectedDate) {
        ExpiryDateCalculator calculator = new ExpiryDateCalculator();
        LocalDate actualExpiryDate = calculator.calculateExpiryDate(payData);
        assertEquals(expectedDate, actualExpiryDate);
    }

}
