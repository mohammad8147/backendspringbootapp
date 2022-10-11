package com.javabackendspringboot.junit;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class todoBusinessImplMockInjectingMokitoTest {
    // using @Mock Annotation
  /*  @Mock
    TodoService todoServiceMock;
    @Test
    public void testRetriveTodoRelatedToSpring_usingBDD(){

        //Given
        List<String> todos= Arrays.asList("Learn spring MVC");
        given(todoServiceMock.retriveTodo("Dummy")).willReturn(todos);

        TodobusinessImpl todobusinessImpl=new TodobusinessImpl(todoServiceMock );

        //When
        List<String> filteredTodo= todobusinessImpl
                .retriveTodosRelatedToString("dummy");
        //Then
        assertEquals(0,filteredTodo.size());

    }*/
    // using @Mock and @InjectMocks
    // using Role
   // @Rule
   // public MokitoRule mokitoRule= new MokitoJUnit.rule();
    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodobusinessImpl todobusinessImpl;
    @Test
    public void testRetriveTodoRelatedToSpring_usingBDD(){

        //Given
        List<String> todos= Arrays.asList("Learn spring MVC");
        given(todoServiceMock.retriveTodo("Dummy")).willReturn(todos);

        //When
        List<String> filteredTodo= todobusinessImpl
                .retriveTodosRelatedToString("dummy");
        //Then
        assertEquals(0,filteredTodo.size());

    }
}
