package com.javabackendspringboot.junit;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {
    @Test
    public void test(){
        TodoService todoServiceStub=new TodoServiceStub();
        TodobusinessImpl todobusinessImpl=new TodobusinessImpl(todoServiceStub );
       List<String> filteredTodo= todobusinessImpl.retriveTodosRelatedToString("dummy");
    assertEquals(2,filteredTodo.size());

    }

}
