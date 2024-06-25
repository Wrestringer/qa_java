package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


import static com.example.constants.AnimalFamilies.FAMILY_OF_FELINE;
import static com.example.constants.DefaultNumbersOfKittens.DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE;
import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.RandomValues.RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE;


public class FelineTests {

    @Spy
    Feline feline;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkEatMeat() throws Exception {
        Assert.assertEquals(PREDATOR_FOOD_LIST, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }

    @Test
    public void checkGetKittensWithoutParameters() throws Exception {
        Assert.assertEquals(DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE);
    }

    @Test
    public void checkGetKittensWithParameters() throws Exception {
        Assert.assertEquals(RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE, feline.getKittens(RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE));
        Mockito.verify(feline, Mockito.times(1)).getKittens(RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE);
    }

    @Test
    public void checkGetFamily() throws Exception {
        Assert.assertEquals(FAMILY_OF_FELINE, feline.getFamily());
    }

}
