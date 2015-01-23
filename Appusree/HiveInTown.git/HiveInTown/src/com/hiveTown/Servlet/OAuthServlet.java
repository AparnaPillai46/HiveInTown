package com.hiveTown.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class OAuthServlet
 */
@WebServlet(description = "Servlet to connect to FB,Google", urlPatterns = { "/OAuthServlet" })
public class OAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OAuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello...");
		
		OAuthService service = new ServiceBuilder()
        .provider(GoogleApi.class)
        .apiKey("115339214932-02858isdpdluo90jscthc4ssnhpbufvm.apps.googleusercontent.com")
        .apiSecret("9wjZWkOwz1RnYMWFGD7Asmfg")
        .build();
		
		Token requestToken = service.getRequestToken();
	
	
		String authUrl = service.getAuthorizationUrl(requestToken);
	
	
		Verifier v = new Verifier("verifier you got from the user");
		Token accessToken = service.getAccessToken(requestToken, v); // the requestToken you had from step 2
		
		
		OAuthRequest request1 = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v1/userinfo?alt=json");
		service.signRequest(accessToken, request1); // the access token from step 4
		Response response1 = request1.send();
		System.out.println(response1.getBody());
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
