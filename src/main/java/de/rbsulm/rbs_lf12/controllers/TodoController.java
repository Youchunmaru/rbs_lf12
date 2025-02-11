package de.rbsulm.rbs_lf12.controllers;

import de.rbsulm.rbs_lf12.model.Todo;
import de.rbsulm.rbs_lf12.mysql.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller // This means that this class is a Controller
@RequestMapping(path="/todo") // This means URL's start with /demo (after Application path)
public class TodoController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private TodoRepository todoRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewTodo (@RequestParam String title
      , @RequestParam String description, @RequestParam Date dueDate) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    Todo n = new Todo();
    n.setTitle(title);
    n.setDescription(description);
    n.setDueDate(dueDate);
    todoRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Todo> getAllUsers() {
    // This returns a JSON or XML with the users
    return todoRepository.findAll();
  }
}
