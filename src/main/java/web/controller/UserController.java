package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.ServiceUser;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

	private ServiceUser serviceUser;

	@Autowired
	public UserController(ServiceUser serviceUser) {
		this.serviceUser = serviceUser;
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		model.addAttribute("userList", serviceUser.userList());
		return "userList";
	}

	@GetMapping("/showUser")
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user, Model model) {
		serviceUser.addUser(user);
		model.addAttribute("userList", serviceUser.userList());
		return "redirect:/api/users";
	}

	@GetMapping("/update")
	public String update(Model model){
		model.addAttribute("user", new User());
		return "update";

	}

	@GetMapping("/delUser")
	public String showDeleteForm(Model model) {
		model.addAttribute("userIdForm", new User());
		return "del";
	}

	@PostMapping("/del")
	public String delete(@ModelAttribute User userIdForm) {
		serviceUser.delById(userIdForm.getId());
		return "redirect:/api/users";
	}


	
}