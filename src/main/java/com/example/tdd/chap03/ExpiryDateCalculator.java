package com.example.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonth = getAddedMonth(payData);

        if (payData.getFirstBillingDate() != null) {
            return expiryDateByFirstBillingDate(payData, addedMonth);
        } else {
            return payData.getBillingDate().plusMonths(addedMonth);
        }
    }

    private int getAddedMonth(PayData payData) {
        if (payData.getPayAmount() < 100000) {
            return payData.getPayAmount() / 10000;
        } else {
            int year = payData.getPayAmount() / 100000;
            int month = (payData.getPayAmount() - (100000 * year)) / 10000;
            return year * 12 + month;
        }
    }

    private LocalDate expiryDateByFirstBillingDate(PayData payData, int addedMonth) {
        final var cadidateDate = payData.getBillingDate().plusMonths(addedMonth);
        final var dayOfFirstBillingDate = payData.getFirstBillingDate().getDayOfMonth();
        if (!isSameLastDayOfMonth(dayOfFirstBillingDate, cadidateDate.getDayOfMonth())) {
            final var lastDayOfCandidateMonth = YearMonth.from(cadidateDate).lengthOfMonth();
            final var lastDayOfMonth = getLastDayOfMonth(lastDayOfCandidateMonth,
                dayOfFirstBillingDate);
            return cadidateDate.withDayOfMonth(lastDayOfMonth);
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
