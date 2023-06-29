package kiteApis;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import utils.EndPointReader;
import utils.PropertyReader;
import utils.SessionReader;

public abstract class Kite {
	
	public SessionReader sessionReader ;
	
	public EndPointReader endPointReader;
	
	public RequestSpecBuilder requestBuilder;
	
	Response response ;
	
	public Kite() throws IOException
	{
		sessionReader = new SessionReader();
		
		endPointReader = new EndPointReader();
		
		requestBuilder = new RequestSpecBuilder();
	}
	
	public void get()
	{
		response = RestAssured.given(requestBuilder.build()).get();
	}

}
