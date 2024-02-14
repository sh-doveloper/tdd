package com.example.tdd.chap02;

import org.springframework.util.StringUtils;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {

        if (!StringUtils.hasText(s)) {
            return PasswordStrength.INVALID;
        }

        boolean lengthEnough = s.length() >= 8;
        boolean containsNumber = meetContainingNumberCriteria(s);
        boolean containsUpperCase = meetContainingUpperCaseCriteria(s);

        if (lengthEnough && !containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough && containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }

        if (!containsUpperCase) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;

    }

    private boolean meetContainingUpperCaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
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
