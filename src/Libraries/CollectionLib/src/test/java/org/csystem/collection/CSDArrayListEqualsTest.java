package org.csystem.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CSDArrayListEqualsTest {
    @Test
    void givenValues_whenLists_thenEquals()
    {
        var list1 = new CSDArrayList<String>();
        var list2 = new CSDArrayList<String>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("1");
        list2.add("2");
        list2.add("3");

        assertEquals(list1, list2);
    }

    @Test
    void givenValues_whenLists_thenLengthNotEqual()
    {
        var list1 = new CSDArrayList<String>();
        var list2 = new CSDArrayList<String>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("1");
        list2.add("2");

        assertNotEquals(list1, list2);
    }

    @Test
    void givenValues_whenLists_thenDataNotEqual()
    {
        var list1 = new CSDArrayList<String>();
        var list2 = new CSDArrayList<String>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("1");
        list2.add("2");
        list2.add("4");

        assertNotEquals(list1, list2);
    }

    @Test
    void givenValues_whenSameLists_thenEquals()
    {
        var list1 = new CSDArrayList<String>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        assertEquals(list1, list1);
    }


    @Test
    void givenValues_whenListAndOtherTypedObject_thenNotEqual()
    {
        var list1 = new CSDArrayList<String>();

        list1.add("1");
        var s = "1";

        assertNotEquals(list1, s);
    }
}
