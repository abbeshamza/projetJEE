package com.tn.isamm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tn.isamm.services.PanierService;

@Controller
@SessionAttributes("panier")
public class PanierController {
	@Autowired
	private PanierService panierService ;

}
