package com.tn.isamm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.env.ISourceMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tn.isamm.entities.User;

import sun.invoke.empty.Empty;


public class AdminInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("userC");
		if( u.getRole().equals("admin") == false)
		{
			response.sendRedirect(request.getContextPath()+"/app");
			return false;
			
		}
		
		return super.preHandle(request, response, handler);
	}
	

}
