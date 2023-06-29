package algo;

import java.io.IOException;

import kiteApis.Historical;
import strategy.CandleModel;
import strategy.Stock;

public class VolumeOICompareIndicator {
	
	Historical historical ;
	
	double BuyPrice;
	
	double SellPrice;
	
	public VolumeOICompareIndicator() throws IOException
	{
		historical = new Historical();
	}
	
	public void getIntrdaySignals(Stock stock,Stock stockDer,String date)
	{
		historical.setHistoricalCandles(stock, date);
		
		historical.setHistoricalCandles(stockDer, date);
		
		compareCandleSignals(stock, stockDer);	
	}
	
	public void compareCandleSignals(Stock stock1,Stock stock2)
	{
		if(stock1.getCandles().size() >= stock2.getCandles().size())
		{
			for(int i = 0 ; i < stock2.getCandles().size() ; i++)
			{
				if ((stock1.getCandles().get(i).tradeSignals()) && (stock2.getCandles().get(i).tradeSignals()))
				{
					System.out.println(stock1.name);
					System.out.println(stock1.getCandles().get(i).toString());
				}
			}
		}
		else if ((stock1.getCandles().size() < stock2.getCandles().size()))
		{

			for(int i = 0 ; i < stock1.getCandles().size() ; i++)
			{
				if ((stock1.getCandles().get(i).tradeSignals()) && (stock2.getCandles().get(i).tradeSignals()))
				{
					System.out.println(stock1.name);
					System.out.println(stock1.getCandles().get(i).toString());
				}
			}
		}
	}

}
