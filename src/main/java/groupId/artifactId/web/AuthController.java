/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.web;
		
import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import groupId.artifactId.business.exception.ResourceForbiddenOperationException;
import groupId.artifactId.business.users.UserServiceInterface;

@Controller
public class AuthController {
	
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(ModelAndView mv, Authentication auth) {
		
		if(auth != null && auth.isAuthenticated()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("pages/auth/login");
		return mv;
	}
	
	@RequestMapping(path="/register", method = RequestMethod.GET)
	public ModelAndView getRegisterPage(ModelAndView mv, Authentication auth) {
		
		if(auth != null && auth.isAuthenticated()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("pages/auth/register");
		return mv;
	}
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public ModelAndView doRegister(@RequestParam String email,
	                               @RequestParam String password,
	                               ModelAndView mv,
	                               Authentication auth,
	                               RedirectAttributes ra) {
		
		if(auth != null && auth.isAuthenticated()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		try {
			userService.registerUser(email, passwordEncoder.encodePassword(password, null));
			mv.setViewName("redirect:/");
		} catch (ResourceForbiddenOperationException | UsernameNotFoundException e) {
			mv.setViewName("redirect:/register?error=");
			ra.addFlashAttribute("error", e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping(path="/restore", method = RequestMethod.GET)
	public ModelAndView getPasswordRestorePage(ModelAndView mv, Authentication auth) {
		
		if(auth != null && auth.isAuthenticated()) {
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("pages/auth/restorePassword");
		return mv;
	}
}
