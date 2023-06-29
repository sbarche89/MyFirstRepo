package trade;

import strategy.CandleModel;

public class ShortTrade extends Trade {
	
	public ShortTrade(double entryPrice) {
		
		super(entryPrice);
		
		System.out.println("<<<<<<< ------- SHORT TRADE STARTED ------->>>>>>>");
		
		this.sellPrice = entryPrice;
		
		this.setStopLoss();
		
		this.setBookProfit();
		// TODO Auto-generated constructor stub
	}

	public void setStopLoss()
	{
		this.stopLoss = this.sellPrice * (100 + this.SL)/100;
	}
	
	public void setBookProfit()
	{
		this.bookProfit = this.sellPrice * (100 - this.Profit) / 100;
	}

	@Override
	public boolean exitSignal(CandleModel candle) {

		if(candle.low <= bookProfit)
		{
			this.buyPrice = bookProfit;
			
			return true;
		}
		
		if(candle.high >= stopLoss)
		{
			this.buyPrice = stopLoss;
			
			return true;
		}
		
		if(candle.time.contains("T15:00:00"))
		{
			this.buyPrice = candle.close;
			
			return true;
		}
		
		return false;
	}

}
