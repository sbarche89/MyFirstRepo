package utils;

import java.io.IOException;

public class SessionReader {
	
	PropertyReader sessionReader ;
	
	public SessionReader() throws IOException
	{
		sessionReader = new PropertyReader("C:\\Users\\Neha\\Algo\\Trade\\src\\main\\resources\\session.properties");
	}
	
	public String getCookie()
	{
		return sessionReader.getPropValue("Cookie");
	}
	
	public String getCSRFToken()
	{
		return sessionReader.getPropValue("CSRFToken");
	}

	
	public String getAuth()
	{
		return sessionReader.getPropValue("Auth");
	}


}
