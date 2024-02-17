package com.example.tdd.chap03;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PayData {

    private LocalDate billingDate;
    private int payAmount;
    private LocalDate firstBillingDate;

}


