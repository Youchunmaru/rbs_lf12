package de.rbsulm.rbs_lf12.controllers;

import de.rbsulm.rbs_lf12.model.Todo;
import de.rbsulm.rbs_lf12.mysql.TodoRepository;
import de.rbsulm.rbs_lf12.mysql.UserRepository;
import de.rbsulm.rbs_lf12.services.EmailService;
import de.rbsulm.rbs_lf12.services.SchedulerService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/todo") // This means URL's start with /demo (after Application path)
public class TodoController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private TodoRepository todoRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private SchedulerService schedulerService;
  @Autowired
  private EmailService emailService;

  @GetMapping(path = "/show")
  public String show(Model model) {
    HomeController.defaultSiteSetup(model, userRepository).addAttribute("todos", todoRepository.findAllByUser_Id(HomeController.getCurrentUser(userRepository).getId()));
    return "todos";
  }
  @GetMapping(path = "/edit/{id}")
  public String edit(Model model, @PathVariable int id) {
    final Optional<Todo> todo = todoRepository.findById(id);
    todo.ifPresent(value -> HomeController.defaultSiteSetup(model, userRepository).addAttribute("todo", value));
    return "editTodo";
  }

  public String edit(Model model, @ModelAttribute Todo todo){
    HomeController.defaultSiteSetup(model, userRepository).addAttribute("todo", todo);
    todoRepository.save(todo);
    return "editTodoResult";
  }
  @GetMapping(path = "/newTodo")
  public String newTodo(Model model){
    HomeController.defaultSiteSetup(model, userRepository).addAttribute("todo", new Todo());
    return "newTodo";
  }
  @PostMapping(path = "/newTodo")
  public String newTodo(@ModelAttribute Todo todo, Model model){
    HomeController.defaultSiteSetup(model, userRepository).addAttribute("todo", todo);
    todo.setUser(HomeController.getCurrentUser(userRepository));
    todoRepository.save(todo);
    if (todo.getDueDate() != null && todo.getDueDate().after(new Date())){
      try {
        schedulerService.schedule(todo.getDueDate().toLocalDate().minusDays(1).atStartOfDay(),
                () -> {
                  System.out.println("todo email send");
                  //todo emailService.sendMail("", todo.getTitle(), todo.getDescription());
                });

      }catch (SchedulerException e){
        e.printStackTrace();
      }
    }
    return "newTodoResult";
  }
}
