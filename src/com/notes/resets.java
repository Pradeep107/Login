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

public class resets extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		 String uo=req.getParameter("username"); 
		 String ke =req.getParameter("re");
		 Entity e = new Entity("person" );
		 Query w = new Query("person");
			PreparedQuery pq = ds.prepare(w); 
					for (Entity result : pq.asIterable()){
						String First = (String) result.getProperty("name"); 
						if(uo.equals(First)){
							 result.setProperty( "password" , ke);
							 ds.put(e);
						}
					}
	}

}
