package tn.formation.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

	/**
	 * Show user management UI
	 * @return view : users.jsp
	 */
	@GetMapping("users")
	public String users() {
		return "users";
	}
}
