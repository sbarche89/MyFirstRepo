package utils;

import java.io.IOException;

public class EndPointReader {
	
PropertyReader endPointReader ;
	
	public EndPointReader() throws IOException
	{
		endPointReader = new PropertyReader("C:\\Users\\Neha\\Algo\\Trade\\src\\main\\resources\\EndPoints.properties");
	}
	
	public String getBaseEndPoint()
	{
		return endPointReader.getPropValue("BaseURL");
	}
	
	public String getInsBaseEndPoint()
	{
		return endPointReader.getPropValue("InstrumentBaseURL");
	}
	
	public String getMarketWatchEndPoint()
	{
		return endPointReader.getPropValue("MarketWatch");
	}
	
	public String getInstrumentEndPoint()
	{
		return endPointReader.getPropValue("Instrument");
	}
	
	public String getHistorical()
	{
		return endPointReader.getPropValue("Historical");
	}
	
}
