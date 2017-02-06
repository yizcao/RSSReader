package com.cyz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RSS_SearchAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9048709426090218661L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//the flag, if it not null, means the page come from index.jsp
		String flag= req.getParameter("flag");
		String rssname = req.getParameter("rssname");
		
		System.out.println("RSSName --> " + rssname);
		System.out.println("FLAG    --> " + flag);
		
		RequestDispatcher dispatcher;
		
		if (flag!=null) {
			//This request is from index.jsp, forward to Loginsucc page
			System.out.println("FLAG is not null, forward to loginsucc.jsp");
			dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginsucc.jsp");
			dispatcher.forward(req, resp);
		}else {
			RSSDriver.rssDriven(rssname);
			
			dispatcher = req.getRequestDispatcher("/WEB-INF/views/succ.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
