package com.example.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonth = payData.getPayAmount() / 10000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateByFirstBillingDate(payData, addedMonth);
        } else {
            return payData.getBillingDate().plusMonths(addedMonth);
        }
    }

    private LocalDate expiryDateByFirstBillingDate(PayData payData, int addedMonth) {
        final var cadidateDate = payData.getBillingDate().plusMonths(addedMonth);
        final var dayOfFirstBillingDate = payData.getFirstBillingDate().getDayOfMonth();
        if (!isSameLastDayOfMonth(dayOfFirstBillingDate, cadidateDate.getDayOfMonth())) {
            final var lastDayOfCandidateMonth = YearMonth.from(cadidateDate).lengthOfMonth();
            return cadidateDate.withDayOfMonth(getLastDayOfMonth(lastDayOfCandidateMonth,
                dayOfFirstBillingDate));
        } else {
            return cadidateDate;
        }
    }

    private int getLastDayOfMonth(int lastDayOfCandidateMonth, int dayOfFirstBillingDate) {
        return Math.min(lastDayOfCandidateMonth, dayOfFirstBillingDate);
    }

    private boolean isSameLastDayOfMonth(int dayOfFirstBillingDate, int dayOfCandidateDate) {
        return dayOfFirstBillingDate == dayOfCandidateDate;
    }
}
