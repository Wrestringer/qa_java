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

import static com.example.constants.DefaultNumbersOfKittens.DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE;
import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.SexAnimal.FEMALE_SEX_ANIMAL;
import static com.example.constants.SexAnimal.MALE_SEX_ANIMAL;

@RunWith(Parameterized.class)
public class LionTests {

    @Spy
    Feline feline;

    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean hasMane;
    @Parameterized.Parameter(2)
    public List <String> listOfFood;
    @Parameterized.Parameter(3)
    public int numberOfKittens;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { MALE_SEX_ANIMAL, true, PREDATOR_FOOD_LIST, DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE },
                { FEMALE_SEX_ANIMAL, false, PREDATOR_FOOD_LIST, DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void checkLionHasMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void checkLionGetKittens() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(numberOfKittens, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void checkLiongetFood() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(listOfFood, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }

}
