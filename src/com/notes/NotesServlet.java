package com.notes;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class NotesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity e = new Entity("person");
		e.setProperty("Firstname", "Tom" );
		e.setProperty("Lastname", "Cruse" );
		ds.put(e);
	}
}
