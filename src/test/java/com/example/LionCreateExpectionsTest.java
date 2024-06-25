package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static com.example.constants.ExceptionMessages.EXCEPTION_MESSAGE_FOR_CREATE_OBJECT_LION;


public class LionCreateExpectionsTest {

    @Spy
    Feline feline;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkCreateLionException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage(EXCEPTION_MESSAGE_FOR_CREATE_OBJECT_LION);
        new Lion(feline, "randomString213");
    }
}
