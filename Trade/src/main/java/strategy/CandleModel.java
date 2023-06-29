package strategy;

import java.util.List;

import trade.LongTrade;
import trade.ShortTrade;
import trade.Trade;


public class CandleModel {
	
	public double open;
	
	public double high;
	
	public double low;
	
	public double close;
	
	public int volume;
	
	public int openInterest;
	
	public String time;
	
	public String candleDuration;
	
	public int avgVol ;
	
	public int avgOI ;
	
	public double dayHigh;
	
	public double dayLow;
	
	public static Trade trade ;
	
	public CandleModel()
	{}
	
	public CandleModel(List<String> candleDetails)
	{
		this.time = candleDetails.get(0);
		
		this.open = Double.valueOf(candleDetails.get(1));
		
		this.high = Double.valueOf(candleDetails.get(2));
		
		this.low = Double.valueOf(candleDetails.get(3));
		
		this.close = Double.valueOf(candleDetails.get(4));
		
		this.volume = Integer.valueOf(candleDetails.get(5));
		
		this.openInterest = Integer.valueOf(candleDetails.get(6));
		
		this.candleDuration = "5";	
	}
	
	public CandleModel(List<String> candleDetails,double dayHigh,double dayLow,int averVol,int averOI)
	{
		this.time = candleDetails.get(0);
		
		this.open = Double.valueOf(candleDetails.get(1));
		
		this.high = Double.valueOf(candleDetails.get(2));
		
		this.low = Double.valueOf(candleDetails.get(3));
		
		this.close = Double.valueOf(candleDetails.get(4));
		
		this.volume = Integer.valueOf(candleDetails.get(5));
		
		this.openInterest = Integer.valueOf(candleDetails.get(6));
		
		this.dayHigh = dayHigh;
		
		this.dayLow = dayLow;
		
		this.avgVol = averVol;
		
		this.avgOI = averOI;
		
		this.candleDuration = "5";	
	}
	
	public String toString()
	{
		return this.time + " - "+ this.open + " - " + this.high + " - " + this.low + " - " + this.close + " - " + 
				this.volume + " - " + this.avgVol + " - " + this.openInterest + " - " + this.avgOI
				+ " - " + this.dayHigh + " - " + this.dayLow
				+ candleSignal();
	}
	
	public boolean tradeSignals()
	{
		if(null == trade && isBuySignal())
		{
			trade = new LongTrade(close);
			
			return true;
		}
		
		if(null == trade && isSellSignal())
		{
			trade = new ShortTrade(close);
			
			return true;
		}
		
		if(null != trade && (trade.exitSignal(this)))
		{	
			
			trade.exitTrade();
			
			trade = null;
			
			return true;
		}
		
		return false;
	}
	
	public String candleSignal()
	{
		return isBuySignal() ? " -> BUY" : (isSellSignal() ? " -> SELL":"");
	}
	
	public boolean isBuySignal()
	{
		return !this.time.contains("T13:") && !this.time.contains("T14:") && !this.time.contains("T15:") && isCandleClosingDayHigh() && isAvgOIIncreasedBy() && isAvgVolIncreasedBy() && isBoolishCandle();
	}
	
	public boolean isSellSignal()
	{
		return  !this.time.contains("T13:") && !this.time.contains("T14:") && !this.time.contains("T15:") && isCandleClosingDayLow() && isAvgOIIncreasedBy() && isAvgVolIncreasedBy() && isBearishCandle();
	}
	
	public boolean isCandleClosingDayHigh()
	{
		return close > dayHigh;
	}
	
	public boolean isCandleClosingDayLow()
	{
		return close < dayLow;
	}
	
	public boolean isAvgVolIncreasedBy()
	{
		return avgVol == 0 ? false : (double)volume/avgVol > 2.5;
	}
	
	public boolean isAvgOIIncreasedBy()
	{
		return avgOI == 0 ? (openInterest == 0 ? true : false) : (double)openInterest/avgOI > 1;
	}
	
	public boolean isBoolishCandle()
	{
		return (close-open >= (high-low)*.75) && ((high-low)/close) * 100 >= 0.5;
	}
	
	public boolean isBearishCandle()
	{
		return (open-close >= (high-low)*.75) && ((high-low)/close) * 100 >= 0.5;
	}

}
