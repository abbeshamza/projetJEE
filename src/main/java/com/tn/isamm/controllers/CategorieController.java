package com.tn.isamm.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.entities.Categorie;
import com.tn.isamm.entities.User;
import com.tn.isamm.services.CategorieService;
import com.tn.isamm.validators.CategorieValidator;
import com.tn.isamm.validators.UserValidator;

@Controller
@SessionAttributes("categorie")
@RequestMapping(value = "/app/admin/categorie")

public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	
	
	
	//////////////////////////////////////////    new ////////////////////////

	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView newCategorie() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("categorie/new");
		model.addObject("categorie", new Categorie());
		model.addObject("categories", categorieService.rechercherTous());
		return model;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView newSubmit( @Valid @ModelAttribute("categorie")  Categorie categorie, Errors errors ) {

		ModelAndView model = new ModelAndView();
		if (!errors.hasErrors())
		{
			
			categorieService.enregistrerCategorie(categorie);
			model.addObject("message", "Votre Categorie a été bien enregistré!");
			System.out.println("valide");
			model.setViewName("redirect:/app/admin/categorie/index");
		}
		else
		{ 
			System.out.println("categorie non valide");
			model.setViewName("categorie/new");
		}
		
		return model;
	}
	/////////////////////////////////         Edit                //////////////////////
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCategorie(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("categorie/new");
		model.addObject("categorie", categorieService.rechercherCategorie(id));
		return model;
	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	
	
	
	public ModelAndView editCategorieP( @ModelAttribute("categorie")  Categorie categorie) {
		ModelAndView model = new ModelAndView();
		
		 categorieService.mettreAJourCategorie(categorie);
		 model.setViewName("redirect:/app/admin/categorie/index");
		return model;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	@InitBinder("categorie")
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new CategorieValidator());
		
	}
	

}
