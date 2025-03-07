package de.rbsulm.rbs_lf12.controllers;
import de.rbsulm.rbs_lf12.model.*;
import de.rbsulm.rbs_lf12.mysql.CalendarEventRepository;
import de.rbsulm.rbs_lf12.mysql.SettingsRepository;
import de.rbsulm.rbs_lf12.mysql.TodoRepository;
import de.rbsulm.rbs_lf12.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	CalendarEventRepository calendarEventRepository;

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private SettingsRepository settingsRepository;

	@GetMapping("/")
	public String start(Model model){
		model.addAttribute("forecast", ApiController.getWeather());
		defaultSiteSetup(model, userRepository);
		panelData(model);
		return "index";
	}

	@GetMapping("/home")
	public String home(Model model){
		model.addAttribute("forecast", ApiController.getWeather());
		defaultSiteSetup(model, userRepository);
		panelData(model);
		return "index";
	}

	@GetMapping(path = "/settings")
	public String settings(Model model){
		List<Settings> settingsList = settingsRepository.findAllByUser_Id(HomeController.getCurrentUser(userRepository).getId());
		defaultSiteSetup(model, userRepository).addAttribute("settings", settingsList);
		return "settings";
	}

	@PostMapping(path = "/settings")
	public String settings(Model model, @ModelAttribute List<Settings> settings){
		settings.forEach(s -> s.setUser(HomeController.getCurrentUser(userRepository)));
		settingsRepository.saveAll(settings);
		defaultSiteSetup(model, userRepository).addAttribute("settings", settings);
		return "settings";
	}

	public static Model defaultSiteSetup(Model model, UserRepository userRepository) {
		model.addAttribute("currentUser", HomeController.getCurrentUser(userRepository));
		return model;
	}

	public static User getCurrentUser(UserRepository userRepository) {
		final MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUsername(userDetails.getUsername());
	}

	private Model panelData(Model model) {
		LocalDateTime now = LocalDateTime.now();
		final List<Todo> todosToday = todoRepository.getTodosByDueDateBetween(new Date(now.toEpochSecond(ZoneOffset.UTC) * 1000), new Date(now.toEpochSecond(ZoneOffset.UTC) * 1000));
		final List<Todo> todosTomorrow = todoRepository.getTodosByDueDateBetween(new Date(now.plusDays(1).toEpochSecond(ZoneOffset.UTC) * 1000), new Date(now.plusDays(1).toEpochSecond(ZoneOffset.UTC) * 1000));
		final List<Todo> todosNoDueDate = todoRepository.getTodosByDueDateIsNull();
		final List<CalendarEvent> calendarEventsToday = calendarEventRepository.getCalendarEventsByStartDateAfterAndStartDateBefore(now.toLocalDate().atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000, now.plusDays(1).toLocalDate().atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000);
		final List<CalendarEvent> calendarEventsTomorrow = calendarEventRepository.getCalendarEventsByStartDateAfterAndStartDateBefore(now.toLocalDate().plusDays(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000, now.plusDays(2).toLocalDate().atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000);
		model.addAttribute("todosToday", todosToday.stream().filter(it -> Objects.equals(it.getUser().getId(), HomeController.getCurrentUser(userRepository).getId())).toList())
				.addAttribute("todosTomorrow", todosTomorrow.stream().filter(it -> Objects.equals(it.getUser().getId(), HomeController.getCurrentUser(userRepository).getId())).toList())
				.addAttribute("todosNoDueDate", todosNoDueDate.stream().filter(it -> Objects.equals(it.getUser().getId(), HomeController.getCurrentUser(userRepository).getId())).toList())
				.addAttribute("calendarEventsToday", calendarEventsToday.stream().filter(it -> Objects.equals(it.getUser().getId(), HomeController.getCurrentUser(userRepository).getId())).toList())
				.addAttribute("calendarEventsTomorrow", calendarEventsTomorrow.stream().filter(it -> Objects.equals(it.getUser().getId(), HomeController.getCurrentUser(userRepository).getId())).toList());
		return model;
	}
}
