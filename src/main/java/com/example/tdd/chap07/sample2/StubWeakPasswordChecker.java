package com.example.tdd.chap07.sample2;

import lombok.Getter;

@Getter
public class StubWeakPasswordChecker extends WeakPasswordChecker {

    private boolean weak;

    @Override
    public void setWeakness(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeekness(String pw) {
        return weak;
    }
}
