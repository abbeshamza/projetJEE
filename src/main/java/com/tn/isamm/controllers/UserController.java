package com.tn.isamm.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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

import com.tn.isamm.entities.Panier;
import com.tn.isamm.entities.User;
import com.tn.isamm.services.PanierService;
import com.tn.isamm.services.UserService;
import com.tn.isamm.validators.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {
	
	

	@Autowired
	private UserService userService;
	@Autowired
	private PanierService panierService;
	
	///////////////////////////////////////////////Home////////////////////////////////////////////////
	@RequestMapping(value = { "/app",})
	public ModelAndView index(
			@RequestParam(value = "message", required = false) String message,HttpSession session) {
		User c=(User) session.getAttribute("userC");
		ModelAndView model = new ModelAndView();
		if(c.getRole().equals("admin"))
			model.setViewName("redirect:/app/admin/users");
		else	
		
		
		model.setViewName("redirect:/app/events/index");
		
		return model;
}
	
/////////////////////////////////////////////New User /////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/new");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView newSubmit( @Valid @ModelAttribute("user")  User user, Errors errors,@RequestParam("image") MultipartFile multipartFile,HttpServletRequest request,HttpSession session ) {

		ModelAndView model = new ModelAndView();
		if (!errors.hasErrors())
		{
			//String filePath1 = request.getServletContext().getRealPath("/"); 
			//System.out.println(filePath1);
			
			String orgName = multipartFile.getOriginalFilename();

	        String filePath = orgName;
	        
			File dest = new File(filePath);
	        try {
	            multipartFile.transferTo(dest);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	           System.out.println( "File uploaded failed:" + orgName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			user.setImg(multipartFile.getOriginalFilename());
			userService.enregistrerUser(user);
			session.setAttribute("usercarte", user);
			model.addObject("message", "Votre client a été bien enregistré!");
			model.setViewName("redirect:/carte/new");
		}
		else
		{ 
			System.out.println("client non valide");
			model.setViewName("user/new");
		}
		
		return model;
	}
	//////////////////////////////////////////////Login user////////////////////////////////////////////
	
	

	@RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
	public ModelAndView loginUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");
		model.addObject("user", new User());
		return model;
	}
	
	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginSubmit( @ModelAttribute("user")  User user ,HttpSession session) {

		ModelAndView model = new ModelAndView();
		
		User ucon = userService.loginUser(user);
		if (ucon != null)
		{
			Panier p = (Panier) panierService.rechercherPanierByUser(ucon);
			session.setAttribute("connect", "vrai");
			session.setAttribute("userC", ucon);
			session.setAttribute("panier", p);
			model.setViewName("redirect:/app");
		}
		else
		{ 
			System.out.println("Login ou mot de, passe non valide");
			model.addObject("message", "user.form.login.error");
			model.setViewName("user/login");
		}
		
		return model;
	}
	
	
	
	
	
	
	
	//////////////////////////////////////////////    log out     ////////////////////////////////////
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout( HttpServletRequest session) {

		ModelAndView model = new ModelAndView();
			session.setAttribute("connect", "non");
			try {
				session.logout();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.setViewName("redirect:/");
	
		
		return model;
	}
	
	
	////////////////////////////////////////////////My Profile////////////////////////////////
	
	@RequestMapping(value = "/app/me", method = RequestMethod.GET)
	public ModelAndView myProfile( @ModelAttribute("user")  User user ,HttpSession session) {

		ModelAndView model = new ModelAndView();
		User me = (User)session.getAttribute("userC");
			model.addObject("me", me);
			model.setViewName("user/profile");
	
		
		return model;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	

	////////////////////////////////////////////////Edit My Profile////////////////////////////////
	
	@RequestMapping(value = "/app/me/edit", method = RequestMethod.GET)
	public ModelAndView editmyProfile( @ModelAttribute("user")  User user ,HttpSession session) {

		ModelAndView model = new ModelAndView();
		User me = (User)session.getAttribute("userC");
			model.addObject("user", me);
			model.setViewName("user/edit");
	
		
		return model;
	}
	

	@RequestMapping(value = "/app/me/edit", method = RequestMethod.POST)
	public ModelAndView editUser( @ModelAttribute("user")  User user ,HttpSession session) {

		ModelAndView model = new ModelAndView();
			userService.mettreAJourUser(user);
			model.setViewName("redirect:/app/events/index");
		
			return model;
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
///////////////////////////////////////////////about////////////////////////////////////////////////
@RequestMapping(value = { "/app/about",})
public ModelAndView about(
@RequestParam(value = "message", required = false) String message,HttpSession session) {

ModelAndView model = new ModelAndView();
model.setViewName("home");

return model;
}
	
	
	/////////////////////////////////////     Admin index  ///////////////////////////////////////////////////
	
	
@RequestMapping(value = { "/app/admin/users",})
public ModelAndView indexAdmin(
		@RequestParam(value = "message", required = false) String message,HttpSession session) {
	
	ModelAndView model = new ModelAndView();
	User u = new User();
	model.addObject("user", u);
	model.addObject("users", userService.rechercherTous());
	model.setViewName("user/admin_index");
	
	return model;
}
	
	
////////////////////////////////////////////////////// admin delete ///////////////////////////////////



@RequestMapping(value = "/app/admin/user/delete/{id}", method = RequestMethod.GET)
public ModelAndView delete( @PathVariable int id ) {

	ModelAndView model = new ModelAndView();
	userService.supprimerUser(id);
	model.setViewName("redirect:/app/admin/users");
	
	return model;
}







/////////////////////////////////////////////////////  admin update    /////////////////////////////////////
	
	
@RequestMapping(value = "/app/admin/user/edit/{id}", method = RequestMethod.GET)
public ModelAndView editadmin(@PathVariable int id , @ModelAttribute("user")  User user ,HttpSession session) {

	ModelAndView model = new ModelAndView();
	User u =userService.rechercherUser(id);
		model.addObject("user", u);
		model.setViewName("user/admin_update");

	
	return model;
}



@RequestMapping(value = "/app/admin/user/edit", method = RequestMethod.POST)
public ModelAndView editAddmin( @ModelAttribute("user")  User user ,HttpSession session) {

	ModelAndView model = new ModelAndView();
		userService.mettreAJourUser(user);
		model.setViewName("redirect:/app/admin/users");
	
		return model;
}











/////////////////////////////////////////////////////////////////////////////////////////////////////


	@InitBinder("user")
	public void initBinder(WebDataBinder binder)
	{
		binder.addValidators(new UserValidator());
		
	}


}
