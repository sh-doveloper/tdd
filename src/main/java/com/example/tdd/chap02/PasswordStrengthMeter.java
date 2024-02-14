package com.example.tdd.chap02;

import org.springframework.util.StringUtils;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {

        if (!StringUtils.hasText(s)) {
            return PasswordStrength.INVALID;
        }

        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        boolean containsNum = meetContainingNumberCriteria(s);

        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;

    }

    private boolean meetContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
