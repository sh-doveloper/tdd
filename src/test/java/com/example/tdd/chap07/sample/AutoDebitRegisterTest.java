package com.example.tdd.chap07.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoDebitRegisterTest {

    private AutoDebitRegister register;
    private StubCardNumberValidator stubCardNumberValidator;
    private AutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        stubCardNumberValidator = new StubCardNumberValidator();
//        register = new AutoDebitRegister(stubCardNumberValidator, );
    }

    @Test
    void register() {
    }
}