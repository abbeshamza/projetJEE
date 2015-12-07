package com.tn.isamm.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.tn.isamm.entities.Event;
import com.tn.isamm.entities.Reservation;
import com.tn.isamm.entities.User;
import com.tn.isamm.services.CategorieService;
import com.tn.isamm.services.EventService;

@Controller
@SessionAttributes("event")
@RequestMapping(value = "/app")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CategorieService categorieService;
	
	////////////////////////////////////// index //////////////////////////////////////////////////
	
	@RequestMapping(value = { "/events/index",})
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("event/index");
		model.addObject("events", eventService.rechercherTous());
		return model;
}
	
	//////////////////////////////////////// new /////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/events/new", method = RequestMethod.GET)
	public ModelAndView newEvent() {
		ModelAndView model = new ModelAndView();
		model.setViewName("event/new");
		model.addObject("event", new Event());
		model.addObject("categories", categorieService.rechercherTous());
		model.addObject("categorie",(List) categorieService.rechercherTous());
		return model;
	}
	
	
	@RequestMapping(value = "/events/new", method = RequestMethod.POST)
	public ModelAndView newSubmit(  @ModelAttribute("event")  Event event, Errors errors,@RequestParam("image") MultipartFile multipartFile,@RequestParam("categoriee") String categorie,HttpServletRequest request,HttpSession session ) {

		ModelAndView model = new ModelAndView();
		System.out.println(categorie);
		if (!errors.hasErrors())
		{
			//String filePath1 = request.getServletContext().getRealPath("/"); 
			//System.out.println(filePath1);
			
			String orgName = multipartFile.getOriginalFilename();

	        String filePath =  orgName;
	        
			File dest = new File(filePath);
	        try {
	            multipartFile.transferTo(dest);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	           System.out.println( "File uploaded failed:" + orgName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	       
	        event.setUser((User)session.getAttribute("userC"));
			event.setImg(multipartFile.getOriginalFilename());
			event.setCategorie(categorieService.rechercherCategorieByLabel(categorie));
			eventService.enregistrerEvent(event);
			model.addObject("message", "Votre event a été bien enregistré!");
			model.setViewName("redirect:/app");
		}
		else
		{ 
			System.out.println("event non valide");
			model.addObject("categories", categorieService.rechercherTous());
			model.setViewName("event/new");
		}
		
		return model;
	}
	//////////////////////////////////////////////event show////////////////////////////////////////////
	
	@RequestMapping(value = "/events/show/{id}", method = RequestMethod.GET)
	public ModelAndView showEvent(@PathVariable int id, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Reservation reservation = new Reservation();
		session.setAttribute("reservation", reservation);
		model.addObject(reservation);
		model.setViewName("event/show");
		model.addObject("event", eventService.rechercherEvent(id));
		return model;
	}
	
	
	
	
	////////////////////////////////// my events ///////////////////////////
	@RequestMapping(value = "/events/eventme", method = RequestMethod.GET)
	public ModelAndView myEvents(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("event/index");
		User u = (User)session.getAttribute("userC");
		model.addObject("events", eventService.rechercherParUser(u));
		return model;
	}
	
	//////////////////////////////////////             Admin index     ///////////////////////////////////
	
	
	
	
	@RequestMapping(value = { "/admin/events/index",})
	public ModelAndView adminindex() {
		
		ModelAndView model = new ModelAndView();
		Event ev = new Event();
		
		
		
		model.addObject("events", eventService.rechercherTous());
		model.addObject("event",  ev);
		model.addObject("categories", categorieService.rechercherTous());
		model.setViewName("event/admin_index");
		return model;
		
	}
	
	/////////////////////////////////////          admin show ////////////////////////////////
	@RequestMapping(value = "/admin/events/show/{id}", method = RequestMethod.GET)
	public ModelAndView showAdmin(@PathVariable int id, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Reservation reservation = new Reservation();
		session.setAttribute("reservation", reservation);
		model.addObject(reservation);
		model.setViewName("event/show_admin");
		model.addObject("event", eventService.rechercherEvent(id));
		return model;
	}
	
	
	
	
	
	///////////////////////////////////// edit //////////////////////////////////////////////////////
	
	@RequestMapping(value = "/admin/events/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editAdmin(@PathVariable int id, HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.setViewName("event/edit_admin");
		session.setAttribute("reservation",new Reservation());
		model.addObject("categories", categorieService.rechercherTous());
		model.addObject("event", eventService.rechercherEvent(id));
		return model;
	}
	
	
	@RequestMapping(value = "/admin/events/edit", method = RequestMethod.POST)
	public ModelAndView editAdminp(@ModelAttribute("event")  Event event, HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.addObject("categories", categorieService.rechercherTous());
		eventService.mettreAJourEvent(event);
		model.setViewName("redirect:/app/admin/events/index");
		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////// admin delete //////////////////////////////////////////
	
	
	
	@RequestMapping(value = "/admin/events/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteAdmin(@PathVariable int id, HttpSession session) {
		ModelAndView model = new ModelAndView();
		eventService.supprimerEvent(id);
		model.setViewName("redirect:/app/admin/events/index");
		return model;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}

}
