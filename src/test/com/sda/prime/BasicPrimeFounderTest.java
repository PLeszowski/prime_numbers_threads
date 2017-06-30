package com.sda.prime;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicPrimeFounderTest {

    private PrimeFounder primeFounder;

    @Before
    public void setUp() {
        primeFounder = new BasicPrimeFounder();
    }

    @Test
    public void shouldFindFrom2To10() {
        final List<Integer> expected = Arrays.asList(2, 3, 5, 7);

        final List<Integer> actual = primeFounder.find(2, 10);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(false, actual.contains(0));
    }

}