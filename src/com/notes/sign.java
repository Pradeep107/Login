package com.notes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class sign extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		String u= req.getParameter("us");
		String p= req.getParameter("p");
		String cp = req.getParameter("p2");
		Entity e = new Entity("person" );
		e.setProperty("name", u );
		e.setProperty("password", p );
		e.setProperty("Confirm_Password", cp);
		ds.put(e);
	}

}
