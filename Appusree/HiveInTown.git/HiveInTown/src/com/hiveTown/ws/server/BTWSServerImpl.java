package com.hiveTown.ws.server;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hiveTown.useraccount.UserAccountImpl;

@Path("/HTServer")
public class BTWSServerImpl {

	/** The UserAccountImpl. */
	private static UserAccountImpl userAccountImpl = null;

	/**
	 * Gets the single instance .
	 * 
	 * @return single instance of UserAccountImpl
	 */
	public static UserAccountImpl getUserAccountImpl() {
		if (userAccountImpl == null) {
			userAccountImpl = new UserAccountImpl();
		}
		return userAccountImpl;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String testREST() {
		return "<html>" + " <head>" + "<title>" + "Test" + "</title>"
				+ "<head>" + "<body>" + "<h1>" + "SUCCESS GET METHOD!!"
				+ "<h1>" + "</body>" + "</html>";
	}

	@PUT
	@Path("{emailId}")
	@Produces(MediaType.TEXT_HTML)
	public String isValidUser(@PathParam("emailId") String userName) {
		System.out.println("*************************");
		System.out.println(userName);
		// TODO change
		String result = "<html>" + " <head>" + "<title>" + "Test" + "</title>"
				+ "<head>" + "<body>" + "<h1>" + "Not Present!!" + "<h1>"
				+ "</body>" + "</html>";

		if (getUserAccountImpl().isUserValid(userName)) {

			result = "<html>" + " <head>" + "<title>" + "Test" + "</title>"
					+ "<head>" + "<body>" + "<h1>" + "SUCCESS its valid!!"
					+ "<h1>" + "</body>" + "</html>";
		}

		return result;
	}
}
