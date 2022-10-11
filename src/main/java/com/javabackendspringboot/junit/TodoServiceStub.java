package com.javabackendspringboot.junit;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retriveTodo(String user) {
        return Arrays.asList("learn Spring MVC","Learn Spring","Learn Dance");
    }
}
