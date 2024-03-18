package com.example.se2einzelphase;

import java.util.ArrayList;
import java.util.List;

public class CommonAdviserCalculator {
    public static List<String> findDigitsWithCommonDivisor(String MNr){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < MNr.length(); i++) {
            for (int j = i + 1; j < MNr.length(); j++) {
                int nr1 = Character.getNumericValue(MNr.charAt(i));
                int nr2 = Character.getNumericValue(MNr.charAt(j));
                if (hasCommonDivisor(nr1, nr2)) {
                    result.add("Digits on indexes " + i +" and " + j + " are having more then one divisor.");
                }
            }
        }
        return result;
    }
    private static boolean hasCommonDivisor(int a, int b) {
        for (int i = 2; i <= Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }
}
