package com.notes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Login extends HttpServlet
{
   
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	 String un=req.getParameter("username");
		String pw=req.getParameter("password");
//		String myname;
	Entity e = new Entity("person" );
//	e.getProperties();
//	System.out.println(e.getProperties().toString());
//	e.setProperty("name", un );
//	e.setProperty("password", pw );
//	ds.put(e);
//	myname = (String) e.getProperty("name");
	
	
	Query q = new Query("person");
	PreparedQuery pq = ds.prepare(q); 
			for (Entity result : pq.asIterable()) { 
			String firstName = (String) result.getProperty("name"); 
			String password = (String) result.getProperty("password"); 
			if(un.equals(firstName))
			{
				if(pw.equals(password))
				{
					resp.sendRedirect("success.html");
				}
				else
				{
					resp.sendRedirect("failed.html");
				}
			}
			/*else
			{
				resp.sendRedirect("failed1.html");
			}*/
			}
//	System.out.println(myname);
	
	/*if(myname.equals(un))
	{
		resp.sendRedirect("index.html");
	}*/
//	resp.setContentType("text/plain" );
//	resp.getWriter().println("Welcome to GAE");
//   System.out.println("Login is running");
//
//   String un=req.getParameter("username");
//	String pw=req.getParameter("password");
//	System.out.print(un);
//	
//	if(un.equals("admin") && pw.equals("admin"))
//	{
//		System.out.println("Login Success");
//		resp.sendRedirect("success.html");
//		return;
//	}
//	else		
//	{
//		System.out.println("Login Failed");
//
//		//resp.sendRedirect("error.html");
//		return;
//	}
}
}
