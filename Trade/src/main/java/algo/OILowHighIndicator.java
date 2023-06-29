package algo;

import java.io.IOException;

import kiteApis.Historical;
import strategy.CandleModel;
import strategy.Stock;

public class OILowHighIndicator {
	
	Historical historical ;
	
	boolean tradeIndicator = false;
	
	double BuyPrice;
	
	double SellPrice;
	
	public OILowHighIndicator() throws IOException
	{
		historical = new Historical();
	}
	
	public void getIntrdaySignals(Stock stock,String date)
	{
		historical.setHistoricalCandles(stock, date);
		
		stock.getCandles().stream().filter(e -> !e.candleSignal().equals("")).forEach(e -> System.out.println(stock.name + " - "+ e.toString()));
	}
}
