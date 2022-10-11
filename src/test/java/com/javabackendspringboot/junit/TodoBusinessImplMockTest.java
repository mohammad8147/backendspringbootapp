package com.javabackendspringboot.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
    //what is mocking?
    //mocking is creating objects that simulate the behavior of real objects.
    //Unlike stubs, mock can be dynamically created from code -at runtime.
    //Mocks offer more functionality than stubbing.
    // you can verify method calls and a lot of other things

    @Test
    public void testRetriveTodoRelatedToSpring_usingAMock(){

        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos= Arrays.asList("Learn spring MVC");
         when(todoServiceMock.retriveTodo("Dummy")).thenReturn(todos);
        TodobusinessImpl todobusinessImpl=new TodobusinessImpl(todoServiceMock );
        List<String> filteredTodo= todobusinessImpl.retriveTodosRelatedToString("dummy");
        assertEquals(1,filteredTodo.size());

    }
    @Test
    public void testRetriveTodoRelatedToSpring_usingBDD(){

        //Given
        TodoService  todoServiceMock = mock(TodoService.class);
        List<String> todos= Arrays.asList("Learn spring MVC");
        given(todoServiceMock.retriveTodo("Dummy")).willReturn(todos);

        TodobusinessImpl todobusinessImpl=new TodobusinessImpl(todoServiceMock );

        //When
        List<String> filteredTodo= todobusinessImpl
                .retriveTodosRelatedToString("dummy");
        //Then
        assertEquals(0,filteredTodo.size());

    }

}
