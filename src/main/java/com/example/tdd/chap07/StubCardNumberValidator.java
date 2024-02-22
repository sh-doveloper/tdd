package com.example.tdd.chap07;

import lombok.Setter;
import org.springframework.util.StringUtils;

public class StubCardNumberValidator extends CardNumberValidator {

    @Setter
    private String invalidNo;

    @Override
    public CardValidity validate(String cardNumber) {
        if (StringUtils.hasText(invalidNo) && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        } else {
            return CardValidity.VALID;
        }
    }
}
