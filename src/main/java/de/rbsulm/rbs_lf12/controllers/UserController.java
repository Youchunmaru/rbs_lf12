package de.rbsulm.rbs_lf12.controllers;

import de.rbsulm.rbs_lf12.model.User;
import de.rbsulm.rbs_lf12.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  @GetMapping("/show")
  public String users(Model model) {
    model.addAttribute("users", userRepository.findAll());
    return "users";
  }

  @GetMapping("/newUser")
  public String addNewUserFrom(Model model){
    model.addAttribute("user", new User());
    return "userForm";
  }

  @PostMapping(path="/newUser") // Map ONLY POST Requests
  public String addNewUser(@ModelAttribute User user, Model model) {
    model.addAttribute("user", user);

    final String password = new BCryptPasswordEncoder().encode(user.getPassword());
    user.setPassword(password);
    user.setEnabled(true);
    userRepository.save(user);
    return "userFormResult";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}
