package com.tn.isamm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.entities.User;
import com.tn.isamm.services.UserService;
import com.tn.isamm.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message) {

		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("clients", userService.rechercherTous());

		if (message != null) {
			model.addObject("showmsg", true);
			model.addObject("message", message);
		} else {
			model.addObject("showmsg", false);
		}
		
		return model;
}

	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("nouveauClient");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newClientSubmit( @Valid @ModelAttribute("user")  User user, Errors errors) {

		ModelAndView model = new ModelAndView();
		if (!errors.hasErrors())
		{
			System.out.println("ici");
			userService.enregistrerUser(user);
			model.addObject("message", "Votre client a été bien enregistré!");
			model.setViewName("redirect:/home");
		}
		else
		{
			System.out.println("client non valide");
			model.setViewName("nouveauClient");
		}
			
		
		
		
		return model;
	}
	@InitBinder("user")
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new UserValidator());
		
	}


}
