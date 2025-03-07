package de.rbsulm.rbs_lf12.controllers;
import de.rbsulm.rbs_lf12.model.MyUserDetails;
import de.rbsulm.rbs_lf12.model.User;
import de.rbsulm.rbs_lf12.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String start(Model model){
		model.addAttribute("forecast", ApiController.getWeather());
		defaultSiteSetup(model, userRepository);
		return "index";
	}

	@GetMapping("/home")
	public String home(Model model){
		model.addAttribute("forecast", ApiController.getWeather());
		defaultSiteSetup(model, userRepository);
		return "index";
	}

	public static Model defaultSiteSetup(Model model, UserRepository userRepository) {
		final MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final User user = userRepository.findByUsername(userDetails.getUsername());
		model.addAttribute("currentUser", user);
		return model;
	}
}
