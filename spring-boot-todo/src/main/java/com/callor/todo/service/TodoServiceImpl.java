package com.callor.todo.service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{


    private final TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public List<TodoVO> selectAll() {
        return todoDao.findAll();
    }

    @Override
    public TodoVO findById(Long seq) {
        return todoDao.findById(seq).orElse(null);
    }

    @Override
    public void insert(TodoVO todoVO) {

        todoDao.save(todoVO);
    }

    @Override
    public void update(TodoVO todoVO) {
        todoDao.save(todoVO);

    }

    @Override
    public void delete(Long seq) {

    }
}
