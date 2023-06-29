package kiteApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.HistoricalData;
import strategy.CandleModel;
import strategy.Stock;

public class Historical extends Kite {
	
	public List<CandleModel> candles = new ArrayList<CandleModel>();
	
	public String date = "";
	
	public Historical() throws IOException {
			
			requestBuilder.setBaseUri(endPointReader.getBaseEndPoint());
			
			requestBuilder.setBasePath(endPointReader.getHistorical());
			
			requestBuilder.setContentType("application/x-www-form-urlencoded");
			
			requestBuilder.addHeader("authorization", sessionReader.getAuth());
			
			requestBuilder.addHeader("cookie", sessionReader.getCookie());
			
		}
	
	public HistoricalData fetchHistorical(Stock stock,String date)
	{
		candles.clear();
		
		requestBuilder.removePathParam("pid");
		
		requestBuilder.removeQueryParam("user_id");
		
		requestBuilder.removeQueryParam("oi");
		
		requestBuilder.removeQueryParam("from");
		
		requestBuilder.removeQueryParam("to");
		
		requestBuilder.addPathParam("pid", stock.token);
		
		requestBuilder.addQueryParam("user_id", "VPM295");
		
		requestBuilder.addQueryParam("oi", "1");
		
		requestBuilder.addQueryParam("from", date);
		
		requestBuilder.addQueryParam("to", date);
		
		get();
		
		return response.as(HistoricalData.class);
	}
	
	public void setHistoricalCandles(Stock stock,String date)
	{	
		fetchHistorical(stock,date).getData().getCandles().stream().forEach(e -> candles.add(new CandleModel(e,setDaysHigh(),setDayLows(),setAverageVol(5),setAverageOI(5))));
		
		stock.setCandles(candles);
	}
	
	
	/*************************************************************************/
	public Double setDayLows()
	{
		return this.candles.stream().map(e -> e.low).collect(Collectors.toList()).stream().min(Comparator.naturalOrder()).orElse(0.0);
		
	}
	
	public Double setDaysHigh()
	{
		return this.candles.stream().map(e -> e.high).collect(Collectors.toList()).stream().max(Comparator.naturalOrder()).orElse(0.0);
	}
	
	public int setAverageVol(int candleCount)
	{
		int avgVol = 0;
		
		if(this.candles.size() < candleCount)
		{
			return avgVol;
		}
		else
		{	
			for(int i = this.candles.size()-candleCount; i < this.candles.size();i++)
			{
				avgVol = avgVol + this.candles.get(i).volume;
			}
			
			return avgVol/candleCount;
		}
	}
	
	public int setAverageOI(int candleCount)
	{
		int avgOI = 0;
		
		if(this.candles.size() < candleCount)
		{
			return avgOI;
		}
		else
		{	
			for(int i = this.candles.size()-candleCount; i < this.candles.size();i++)
			{
				avgOI = avgOI + this.candles.get(i).openInterest;
			}
			
			return avgOI/candleCount;
		}
	}
}
