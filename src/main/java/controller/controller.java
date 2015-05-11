package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/jira")
public class controller {
	
	@GET
	@Produces("text/plain")
	public String hello(){
		return "hello";
	}
	
}
