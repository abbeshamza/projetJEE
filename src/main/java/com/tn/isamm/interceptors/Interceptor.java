package com.tn.isamm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.env.ISourceMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sun.invoke.empty.Empty;

public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		if( session.getAttribute("connect") == null)
		{
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
			
		}
		
		return super.preHandle(request, response, handler);
	}
	
	

}
