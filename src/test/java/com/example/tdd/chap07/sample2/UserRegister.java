package com.example.tdd.chap07.sample2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRegister {

    private final WeakPasswordChecker weakPasswordChecker;

    public void register(String id, String pw, String email) {
        if (weakPasswordChecker.checkPasswordWeekness(pw)) {
            throw new WeakPasswordException();
        }
    }
}
