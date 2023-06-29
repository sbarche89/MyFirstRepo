package trade;

import strategy.CandleModel;

public abstract class Trade {
	
	public double SL = 0.40;
	
	public double Profit = 1.00;
	
	public double buyPrice;
	
	public double sellPrice;
	
	public double stopLoss;
	
	public double bookProfit;
	
	public double pointers;
	
	public Trade(double entryPrice)
	{
		
	}
	
	public void exitTrade()
	{	
		if(this.buyPrice >= this.sellPrice)
		{
			System.out.println("<<<<<<< ------- TRADE SQUARED OFF WITH LOSS------->>>>>>>");
		}
		else
		{
			System.out.println("<<<<<<< ------- TRADE SQUARED OFF WITH PROFIT------->>>>>>>");
		}
		
		System.out.println(this.buyPrice);
		
		System.out.println(this.sellPrice);
		
		System.out.println(this.bookProfit);
		
		System.out.println(this.stopLoss);
		
		pointers = pointers - this.buyPrice + this.sellPrice;
		
		System.out.println(pointers);
	}
	
	public abstract boolean exitSignal(CandleModel candle);
	
	public abstract void setStopLoss();
	
	public abstract void setBookProfit();

}
