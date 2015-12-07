package com.tn.isamm.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.entities.Carte;
import com.tn.isamm.entities.User;
import com.tn.isamm.services.CarteService;

@Controller
@SessionAttributes("carte")
@RequestMapping(value="/carte")
public class CarteController {
	@Autowired
	private CarteService carteService ;
/////////////////////////////////////////////////// new ////////////////////////////
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("carte/new");
		model.addObject("carte", new Carte());
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newSubmit( @Valid @ModelAttribute("carte")  Carte carte, Errors errors,HttpSession session ) {

		ModelAndView model = new ModelAndView();
		if (!errors.hasErrors())
		{
			User u =(User) session.getAttribute("usercarte");
			carte.setUser(u);
			carteService.enregistrerCarte(carte);
			model.addObject("message", "Votre client a été bien enregistré!");
			model.setViewName("redirect:/app");
		}
		else
		{ 
			System.out.println("client non valide");
			model.setViewName("carte/new");
		}
		
		return model;

}
	
	//////////////////////////////////////////////////////////////////////////////
	
	
	
	
}
