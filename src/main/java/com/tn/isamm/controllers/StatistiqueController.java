package com.tn.isamm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.services.ReservationService;
import com.tn.isamm.services.StatistiqueService;

import antlr.collections.List;

@Controller
@RequestMapping(value = "/app/admin/")
public class StatistiqueController {
	
	@Autowired
	private StatistiqueService statistiqueService;
	
	@RequestMapping(value = "/stat", method = RequestMethod.GET)
	public ModelAndView newSubmit()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("profit", statistiqueService.moyenne());
		model.addObject("useractif", statistiqueService.userPlusActif());
		model.addObject("userfidele", statistiqueService.userPlusFiele());
		
		model.addObject("m", statistiqueService.eventparcategorie());
		model.addObject("l",statistiqueService.prix_moy_categorie());
		
		
		model.setViewName("admin/stat");
		return model ;
	}

}
