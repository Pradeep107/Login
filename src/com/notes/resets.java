package com.notes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class resets extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 String uo=req.getParameter("username"); 
		 String ke =req.getParameter("re");
		 Entity e = new Entity("person" );
		 Query w = new Query("person");
			PreparedQuery pq = ds.prepare(w);
			PrintWriter out = resp.getWriter();     
			
					for (Entity result : pq.asIterable()){
						String First = (String) result.getProperty("name"); 
						try {
						if(uo.equals(First)){
							HttpSession session = req.getSession();
							String a= (String) session.getAttribute("user1"); 
							out.println(a);
							 result.setProperty( "password" , ke);
							 ds.put(e);
							 RequestDispatcher rd = req.getRequestDispatcher("index.html");
								rd.forward(req, resp);
							 out.println("Password changed sucessfully");
						}
			}finally {} 
	}
	} 

}
