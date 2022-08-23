package com.callor.todo.controller;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final TodoService todoService;

    public HomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = {"","/"})
    public String home(@RequestParam(name = "seq", required = false,defaultValue = "") Long seq, Model model) {

        List<TodoVO> todoList = todoService.selectAll();

        TodoVO todoVO = null;

        if(seq != null) {
            todoVO = todoService.findById(seq);
            log.debug("findBy데이터 {}", todoVO);
        }

        model.addAttribute("TODO", todoVO);
        model.addAttribute("TODOS", todoList);

        return "home";
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public String home(TodoVO todoVO) {

        log.debug("받은 데이터 {}", todoVO);

        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeForm = new SimpleDateFormat("HH:mm:ss");

        todoVO.setS_date(dateForm.format(date));
        todoVO.setS_time(timeForm.format(date));
        todoVO.setComp(false);

        log.debug("{}", todoVO);

        todoService.insert(todoVO);

        return "redirect:/";

    }
}
