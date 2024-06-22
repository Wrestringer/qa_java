package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


@RunWith(Parameterized.class)
public class LionCreateExpectionsTest {

    @Spy
    Feline feline;

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "randomString213" }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test(expected = Exception.class)
    public void checkCreateLionException() throws Exception {
        Lion lion = new Lion(feline, sex);
    }
}
