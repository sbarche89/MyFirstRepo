package trade;

import strategy.CandleModel;

public class LongTrade extends Trade{
	
	public LongTrade(double entryPrice) {
		
		super(entryPrice);
		
		System.out.println("<<<<<<< ------- LONG TRADE STARTED ------->>>>>>>");
		
		this.buyPrice = entryPrice;
		
		this.setStopLoss();
		
		this.setBookProfit();
		
	}

	public void setStopLoss()
	{
		this.stopLoss = this.buyPrice * (100 - this.SL)/100;
	}
	
	public void setBookProfit()
	{
		this.bookProfit = this.buyPrice * (100 + this.Profit)/100;
	}
	
	@Override
	public boolean exitSignal(CandleModel candle) {

		if(candle.low <= stopLoss)
		{
			this.sellPrice = stopLoss;
			
			return true;
		}
		
		if(candle.high >= bookProfit)
		{
			this.sellPrice = bookProfit;
			
			return true;
		}
		
		if(candle.time.contains("T15:00:00"))
		{
			this.sellPrice = candle.close;
			
			return true;
		}
		
		return false;
	}

}
