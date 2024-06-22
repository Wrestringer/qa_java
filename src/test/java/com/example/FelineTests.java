package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static com.example.constants.AnimalFamilies.FAMILY_OF_FELINE;
import static com.example.constants.DefaultNumbersOfKittens.DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE;
import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.RandomValues.RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE;


@RunWith(Parameterized.class)
public class FelineTests {

    @Spy
    Feline feline;

    @Parameterized.Parameter
    public List<String> listOfFood;
    @Parameterized.Parameter(1)
    public int defaultNumberOfKittens;
    @Parameterized.Parameter(2)
    public int numberOfKittens;
    @Parameterized.Parameter(3)
    public String nameOfFamily;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { PREDATOR_FOOD_LIST, DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE, RANDOM_INT_NUMBER_OF_KITTENS_FOR_FELINE , FAMILY_OF_FELINE }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkEatMeat() throws Exception {
        Assert.assertEquals(listOfFood, feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }

    @Test
    public void checkGetKittensWithoutParameters() throws Exception {
        Assert.assertEquals(defaultNumberOfKittens, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens(defaultNumberOfKittens);
    }

    @Test
    public void checkGetKittensWithParameters() throws Exception {
        Assert.assertEquals(numberOfKittens, feline.getKittens(numberOfKittens));
        Mockito.verify(feline, Mockito.times(1)).getKittens(numberOfKittens);
    }

    @Test
    public void checkGetFamily() throws Exception {
        Assert.assertEquals(nameOfFamily, feline.getFamily());
    }

}
