package com.hotaru.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/test")
	public String getMsg() {
		return "hello";
	}
 
}