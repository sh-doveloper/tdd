package com.example.tdd.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonth = 1;
        if (payData.getFirstBillingDate() != null) {
            LocalDate cadidateDate = payData.getBillingDate().plusMonths(addedMonth);
            if (payData.getFirstBillingDate().getDayOfMonth() != cadidateDate.getDayOfMonth()) {
                return cadidateDate.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonth);
    }
}
