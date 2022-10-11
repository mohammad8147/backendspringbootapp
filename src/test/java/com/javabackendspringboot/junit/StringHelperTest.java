package com.javabackendspringboot.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringHelperTest {
    @Test
    public void test(){


 //AACD=> CD ACD=> CD CDEF=> CDEF
StringHelper helper=new StringHelper();
String actual=helper.truncateAInFirst2Positions("AACD");
String expected="CD";
//assertEquals(expected,actual);
assertEquals(actual,expected);


    }
    @Test
    public void truncateAInFirst2Positions(){
        StringHelper helper=new StringHelper();
        assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));

    }
}
