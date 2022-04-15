package test.by.epam.tasks.task1.util;

import by.epam.tasks.task1.util.ColorRandomizer;
import by.epam.tasks.task1.util.ColorValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class ColorUtilTest {

    ColorValidator colorUntil;
    ColorRandomizer colorRandomizer;

    @BeforeMethod
    public void setUp() {
        colorUntil = new ColorValidator();
        colorRandomizer = new ColorRandomizer();
    }

    @Test
    public void testIsValidColor1(){
        assertTrue(colorUntil.isValidColor("blue"));
    }

    @Test
    public void testIsValidColor2(){
        assertTrue(colorUntil.isValidColor("BlAcK"));
    }

    @Test
    public void testIsValidColor3(){
        assertFalse(colorUntil.isValidColor("graph1te"));
    }

    @Test
    public void testGetRandomColor(){
        assertTrue(colorUntil.isValidColor(colorRandomizer.getRandomColor().toString()));
    }


}
