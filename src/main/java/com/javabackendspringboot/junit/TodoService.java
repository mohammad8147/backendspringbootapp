package com.javabackendspringboot.junit;

import java.util.List;
//Create TodoServiceStub
//Test todoBusinessImpl using TodoServiceStub

public interface TodoService {
    public List<String> retriveTodo(String user);
}
