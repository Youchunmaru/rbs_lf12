package de.rbsulm.rbs_lf12.controllers;
import de.rbsulm.rbs_lf12.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/todo")
	public String todo(Model model){
		return "todo";
	}
}
