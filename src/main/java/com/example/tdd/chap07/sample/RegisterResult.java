package com.example.tdd.chap07.sample;

public record RegisterResult() {

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult();
    }

    public static RegisterResult success() {
        return new RegisterResult();
    }
}
