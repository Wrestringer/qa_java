package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.example.constants.AnimalKind.ANIMAL_KIND_PREDATOR;
import static com.example.constants.DefaultNumbersOfKittens.DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE;
import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.SexAnimal.FEMALE_SEX_ANIMAL;
import static com.example.constants.SexAnimal.MALE_SEX_ANIMAL;

@RunWith(Parameterized.class)
public class LionTests {

    @Mock
    Feline feline;

    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean hasMane;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { MALE_SEX_ANIMAL, true },
                { FEMALE_SEX_ANIMAL, false }
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
        Mockito.when(feline.getKittens()).thenReturn(DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE);
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(DEFAULT_NUMBER_OF_KITTENS_FOR_FELINE, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void checkLionGetFood() throws Exception {
        Mockito.when(feline.getFood(ANIMAL_KIND_PREDATOR)).thenReturn(PREDATOR_FOOD_LIST);
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(PREDATOR_FOOD_LIST, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }

}
