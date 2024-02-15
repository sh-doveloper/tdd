package com.example.tdd.chap02;

import org.springframework.util.StringUtils;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {

        if (!StringUtils.hasText(s)) {
            return PasswordStrength.INVALID;
        }

        int meetCount = getMeetCriteriaCounts(s);

        return switch (meetCount) {
            case 2 -> PasswordStrength.NORMAL;
            case 3 -> PasswordStrength.STRONG;
            default -> PasswordStrength.WEAK;
        };

    }

    private int getMeetCriteriaCounts(String s) {
        int meetCount = 0;
        if (s.length() >= 8) {
            meetCount++;
        }
        if (meetContainingNumberCriteria(s)) {
            meetCount++;
        }
        if (meetContainingUpperCaseCriteria(s)) {
            meetCount++;
        }
        return meetCount;
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
