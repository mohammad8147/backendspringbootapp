package com.javabackendspringboot.junit;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void letsMockListSizeMethod(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }
    @Test
    public void letsMockListReturnMultipleValue(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }
    @Test
    public void letsMockListGet(){
        List listMock=mock(List.class);
        //Argument Matcher
        when(listMock.get(anyInt())).thenReturn("mokitos");
        assertEquals("mokitos",listMock.get(0));
        assertEquals("mokitos",listMock.get(1));

    }
    /*@Test
    public void letsMockListGet_usingBDD(){
        //Given
        List<String> listMock=mock(List.class);
        
        //Argument Matcher
        given(listMock.get(anyInt())).willReturn("mokitos");
        
        //When
        String firstName=listMock.get(0);
        //Then
        assertThat(firstName,is("mokito"));


    }*/
    /*@Test(expected=RuntimeException.class)
    public void letsMockList_throwAnException(){
        List listMock=mock(List.class);
        //Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something wrong"));
        listMock.get(0);


    }*/
}
