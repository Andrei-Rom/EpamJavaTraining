package main.by.epam.tasks.task1.util;

import main.by.epam.tasks.task1.util.ColorRandomizer;
import main.by.epam.tasks.task1.util.ColorValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ColorUtilTest {

    ColorValidator colorUntil;
    ColorRandomizer colorRandomizer;

    @BeforeEach
    public void setUp() {
        colorUntil = new ColorValidator();
        colorRandomizer = new ColorRandomizer();
    }

    @Test
    public void testIsValidColor1(){
        Assertions.assertTrue(colorUntil.isValidColor("blue"));
    }

    @Test
    public void testIsValidColor2(){
        Assertions.assertTrue(colorUntil.isValidColor("BlAcK"));
    }

    @Test
    public void testIsValidColor3(){
        Assertions.assertFalse(colorUntil.isValidColor("graph1te"));
    }

    @Test
    public void testGetRandomColor(){
        Assertions.assertTrue(colorUntil.isValidColor(colorRandomizer.getRandomColor().toString()));
    }


}
