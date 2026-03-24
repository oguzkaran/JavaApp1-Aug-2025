package org.csystem.collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CSDArrayListIndexOfTest {
    @Test
    void givenValues_whenListAndReference_thenFound()
    {
        var list = new CSDArrayList<String>();
        var s = "2";
        var index = 1;

        list.add("1");
        list.add("2");
        list.add("3");

        assertEquals(index, list.indexOf(s));
    }

    @Test
    void givenValues_whenListAndReference_thenNotFound()
    {
        var list = new CSDArrayList<String>();
        var s = "4";
        var index = -1;

        list.add("1");
        list.add("2");
        list.add("3");

        assertEquals(index, list.indexOf(s));
    }
}
