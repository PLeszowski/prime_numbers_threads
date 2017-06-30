package com.sda.prime;

import java.util.ArrayList;
import java.util.List;

public class BasicPrimeFounder implements PrimeFounder {
    @Override
    public List<Integer> find(int from, int to) {
        List<Integer> result = new ArrayList<>();

        for (int i = from; i <= to; ++i) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
