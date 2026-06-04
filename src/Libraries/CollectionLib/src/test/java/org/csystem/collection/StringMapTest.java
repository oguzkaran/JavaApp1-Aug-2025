package org.csystem.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringMapTest {
    @Test
    void testAddElementNotExistsAndCount()
    {
        var stringMap = new StringMap<Integer>();
        var expected = 3;

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertEquals(expected, stringMap.count());
    }

    @Test
    void testAddElementExists()
    {
        var stringMap = new StringMap<Integer>();
        var expected = 3;

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertTrue(stringMap.addElement("One", 3));
    }

    @Test
    void testAddElementThrowsException()
    {
        var stringMap = new StringMap<Integer>();


        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.addElement(null, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.addElement("", 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.addElement("   \t", 1));
    }

    @Test
    void testRemoveElementNotExists()
    {
        var stringMap = new StringMap<Integer>();
        var expected = 3;

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertEquals(expected, stringMap.count());
        Assertions.assertFalse(stringMap.removeElement("Four"));
        Assertions.assertEquals(expected, stringMap.count());
    }

    @Test
    void testRemoveElementExists()
    {
        var stringMap = new StringMap<Integer>();
        var expected = 3;

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertEquals(expected, stringMap.count());
        Assertions.assertTrue(stringMap.removeElement("Two"));
        Assertions.assertEquals(expected - 1, stringMap.count());
    }

    @Test
    void testRemoveElementThrowsException()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.removeElement(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.removeElement(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.removeElement("   \t"));
    }

    @Test
    void testGetValueOptionalNotExists()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertTrue(stringMap.getValue("Four").isEmpty());
    }

    @Test
    void testGetValueOptionalExists()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        var opt = stringMap.getValue("One");
        Assertions.assertTrue(opt.isPresent());
        Assertions.assertEquals(1, opt.get());
    }

    @Test
    void testGetValueOptionalThrowsException()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue("   \t"));
    }

    @Test
    void testGetValueNotExists()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertEquals(4, stringMap.getValue("Four", 4));
    }

    @Test
    void testGetValueExists()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertFalse(stringMap.addElement("One", 1));
        Assertions.assertFalse(stringMap.addElement("Two", 2));
        Assertions.assertFalse(stringMap.addElement("Three", 3));
        Assertions.assertEquals(2, stringMap.getValue("Two", 4));
    }

    @Test
    void testGetValueThrowsException()
    {
        var stringMap = new StringMap<Integer>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue(null, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue("", 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stringMap.getValue("   \t", 4));
    }
}
