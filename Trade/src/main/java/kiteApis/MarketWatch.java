package kiteApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.MarketWatchList;
import strategy.Stock;

public class MarketWatch extends Kite {
	
	public List<Stock> stocks = new ArrayList<Stock>();

	public MarketWatch() throws IOException {
		
		requestBuilder.setBaseUri(endPointReader.getBaseEndPoint());
		
		requestBuilder.setBasePath(endPointReader.getMarketWatchEndPoint());
		
		requestBuilder.setContentType("application/x-www-form-urlencoded");
		
		requestBuilder.addHeader("x-csrftoken", sessionReader.getCSRFToken());
		
		requestBuilder.addHeader("cookie", sessionReader.getCookie());
	}
	
	public MarketWatchList fetchMarketWatch()
	{
		get();
		
		return response.as(MarketWatchList.class);
	}

	public List<Stock> getStocks() {
		
		return stocks;
	}
	
	public Stock getStockByName(String name) {
		return stocks.stream().filter(e -> e.name.equalsIgnoreCase(name)).findFirst().get();
	}

	public void setStocks() {
		fetchMarketWatch().getData().stream().forEach(e -> e.getItems().stream().forEach(x -> stocks.add(new Stock(x.getTradingsymbol(), x.getId(), x.getInstrument_token()))));
	}
	
	
}
