package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static com.example.constants.ListsOfAnimalsFood.PREDATOR_FOOD_LIST;
import static com.example.constants.SoundsOfAnimals.CAT_SOUND;

public class CatTests {


    //Здесь необходим именно шпион т.к. в проверке checkGetFood()
    @Mock
    Feline feline;



    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkGetSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals(CAT_SOUND, cat.getSound());
    }

    @Test
    public void checkGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(PREDATOR_FOOD_LIST);
        Cat cat = new Cat(feline);
        Assert.assertEquals(PREDATOR_FOOD_LIST, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}
