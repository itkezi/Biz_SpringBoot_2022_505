package com.callor.todo.service;

import com.callor.todo.model.TodoVO;

import java.util.List;

public interface TodoService {

    public List<TodoVO> selectAll();
    public TodoVO findById(Long seq);
    public void insert(TodoVO todoVO);
    public void update(TodoVO todoVO);
    public void delete(Long seq);

}
