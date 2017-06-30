package com.sda.call;

import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.sda.prime.PrimeFounder;

public class TaskTest {

    private Task task;

    @Mock
    private PrimeFounder primeFounder;

    @Before
    public void setUp() {
        initMocks(this);
        task = new Task(primeFounder, 2, 10);
    }

    @Test
    public void shouldInvokePrimeFounder() throws Exception {
        List<Integer> mockedNumbers = Arrays.asList(2, 3, 5, 7);

        Mockito.when(primeFounder.find(2, 10))
                .thenReturn(mockedNumbers);

        List<Integer> actual = task.call();

        Assert.assertEquals(mockedNumbers, actual);
        Mockito.verify(primeFounder, times(1))
                .find(2, 10);

    }

}