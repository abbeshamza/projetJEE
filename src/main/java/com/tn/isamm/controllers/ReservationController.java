package com.tn.isamm.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tn.isamm.entities.Carte;
import com.tn.isamm.entities.Categorie;
import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;
import com.tn.isamm.services.CarteService;
import com.tn.isamm.services.EventService;
import com.tn.isamm.services.ReservationService;

@Controller
@SessionAttributes("reservation")
@RequestMapping(value = "/app/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CarteService carteService;
	
	
	////////////////////////////////////////////////////// new //////////////////////////////////
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newSubmit( @ModelAttribute("reservation")  Reservation reservation, Errors errors , HttpSession session,@RequestParam("even") int even) {

		ModelAndView model = new ModelAndView();
		if (!errors.hasErrors())
		{
		    Event e = (Event) eventService.rechercherEvent(even);
			Panier p= (Panier) session.getAttribute("panier");
			reservation.setEvent(e);
			reservation.setPanier(p);
			reservation.setStatut("non");
			reservationService.enregistrerReservation(reservation);
			
			model.setViewName("redirect:/app");
		}
		else
		{ 
			System.out.println("categorie non valide");
			model.setViewName("categorie/new");
		}
		
		return model;
	}
	////////////////////////////////////////////  index /////////////////////////////////////
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(   HttpSession session) {

		ModelAndView model = new ModelAndView();
		User u = (User) session.getAttribute("userC");
		session.setAttribute("reservations",reservationService.rechercherParUser(u) );
		model.addObject("reservations", reservationService.rechercherParUser(u));
		System.out.println(reservationService.rechercherParUser(u).size());
			
			model.setViewName("reservation/index");
		
		return model;
	}
	
	
	
	
	///////////////////////////////////    delete        ///////////////////////////////////
	
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete( @PathVariable int id ) {

		ModelAndView model = new ModelAndView();
		reservationService.supprimerReservation(id);
		model.setViewName("redirect:/reservation/index");
		
		return model;
	}
	////////////////////////////////// payer //////////////////////////////////////////////////
	
	@RequestMapping(value = "/payer/{id}", method = RequestMethod.POST)
	public ModelAndView payer(@PathVariable int id,@RequestParam ("pass") String pwd, @RequestParam("num") String numC, HttpSession session, HttpServletRequest req) {

		ModelAndView model = new ModelAndView();
		System.out.println("here");
		Reservation reserv= reservationService.rechercherReservation(id) ;
	
		
		System.out.println(reserv.getPanier().getUser().getEmail());
		
		Carte carte_user = carteService.rechercherCarteParUser(reserv.getPanier().getUser());
		if((carte_user.getNumero().equals(numC) ) &&(carte_user.getPassword().equals(pwd)))
		{
			int mont = reserv.getNbr_place()*reserv.getEvent().getPrix();
			if(carte_user.getSolde()>(reduction(mont)))
					{
				
				System.out.println("password" + pwd);

				carte_user.setSolde(carte_user.getSolde()- (reduction(mont)));
				     reserv.setStatut("oui");
				    carteService.mettreAJourCarte(carte_user);
				    reservationService.mettreAJourReservation(reserv);
				    model.addObject("message", " payement effectuée");
				    model.setViewName("redirect:/reservation/index");
				   
					}
			else
			{
				model.addObject("message", " Solde insuffisant");
				 model.setViewName("redirect:/reservation/index");
			}
				
		
		}
		else
		{
			
			model.addObject("message", " Carte Not found");
			 model.setViewName("redirect:/reservation/index");
			
		}
		
		
		return model;
	}
	
	
	public double reduction (int m)
	{
		if (m<10)
			return m;
		if(m>10 && m<30)
			return m*0.95;
		if(m>30 && m<50)
			return m*0.9;
		if (m>50 && m<100)
			return m*85;
		if(m>100 && m<150)
			return m*0.8 ;
		if (m>150 && m<200)
			return m* 0.75 ;
		 if(m>250)
			 return m * 0.7 ;
		return m;
	}
	
	
	
	
	
	
	
	
	

}
