package kiteApis;

import java.io.IOException;

public class Instruments extends Kite{
	
	public Instruments() throws IOException {
		
		requestBuilder.setBaseUri(endPointReader.getInsBaseEndPoint());
		
		requestBuilder.setBasePath(endPointReader.getInstrumentEndPoint());
		
		requestBuilder.setContentType("application/x-www-form-urlencoded");
		
		requestBuilder.addHeader("x-csrftoken", sessionReader.getCSRFToken());
		
		requestBuilder.addHeader("cookie", sessionReader.getCookie());
	}
	
	public void getIns()
	{
		get();
	}

}
