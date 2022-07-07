package com.fms.distopia.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	/**
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String loginForm() {
		return "loginHtml";
	}

	@RequestMapping("/logout")
	public String logoutForm(HttpServletRequest request) throws ServletException {
		request.logout();
		return "redirect:login";
	}

	

	@GetMapping("registerUser")
	public String register(Model model) {
		model.addAttribute("user", new Uuser());
		return "register";
	}

	@PostMapping("registration")
	public String registration(@Valid Uuser user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
//			model.addAttribute("user", user);
			return "redirect:registerUser";
		}
		user.setActive(true);
		user.getRoles().add(securityService.getRoleByRoleName("USER"));
		securityService.saveUuser(user);
		return "redirect:/login";
	}
}
