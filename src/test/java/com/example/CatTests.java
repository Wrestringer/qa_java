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

import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.SoundsOfAnimals.CAT_SOUND;

@RunWith(Parameterized.class)
public class CatTests {

    @Parameterized.Parameter
    public String catSound;
    @Parameterized.Parameter(1)
    public List<String> listOfFood;


    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { CAT_SOUND, PREDATOR_FOOD_LIST }
        };
    }

    @Spy
    Feline feline;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkGetSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals(catSound, cat.getSound());
    }

    @Test
    public void checkGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Assert.assertEquals(listOfFood, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}
