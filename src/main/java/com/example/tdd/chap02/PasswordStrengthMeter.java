package com.example.tdd.chap02;

public class PasswordStrengthMeter {

  public PasswordStrength meter(String s) {
    if (s.length() < 8) {
      return PasswordStrength.NORMAL;
    } else {
      return PasswordStrength.STRONG;
    }
  }
}
