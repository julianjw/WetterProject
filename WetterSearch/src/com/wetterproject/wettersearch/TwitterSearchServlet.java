package com.wetterproject.wettersearch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TwitterSearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		
	}
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	
		resp.setContentType("text/plain");
    }
}
