package com.javabackendspringboot.junit;

import java.util.ArrayList;
import java.util.List;
//TodoBusinessIpml SUI
//TodoService Dependency
public class TodobusinessImpl {

    private TodoService todoService;

    public TodobusinessImpl(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
    public List<String> retriveTodosRelatedToString(String user){
        List<String>filteredTodo=new ArrayList<String>();
        List<String>todos=todoService.retriveTodo(user);

        for(String todo:todos){
            if(todo.contains("Spring")){
                filteredTodo.add(todo);
            }
        }

        return filteredTodo;


    }
}
