package strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stock {
	
	public String name;
	
	public String id;
	
	public String token;
	
	public double dayLow;
	
	public double dayHigh;
	
	public List<CandleModel> candles = new ArrayList<CandleModel>();
	
	public Stock(String name,String id,String token)
	{
		this.name = name;
		
		this.id = id;
		
		this.token = token;
	}


	public void setCandles(List<CandleModel> candles)
	{
		this.candles.clear();
		
		this.candles.addAll(candles);
		
		//setDayHighsLows();
	}
	
	public List<CandleModel> getCandles()
	{
		return this.candles;
	}
	
	public void getStockDetails()
	{
		System.out.println(this.name + " --- " + this.id + " --- " + this.token);
		
		this.candles.stream().forEach(e -> System.out.println(e.toString()));
	}
	
	/****************************************************/
	/*
	 * public void setDayHighsLows()
	{
		this.dayLow = this.candles.stream().map(e -> e.low).collect(Collectors.toList()).stream().min(Comparator.naturalOrder()).get();
		
		this.dayHigh = this.candles.stream().map(e -> e.high).collect(Collectors.toList()).stream().max(Comparator.naturalOrder()).get();
	}
	
	public void setDiffVolume(int candleCount)
	{
		double average;
		
		int j ;
		
		for(j = 0; j < this.candles.size()-candleCount;j++)
		{
			average = 0.0;
			
			for(int i = j ; i < j + candleCount ; i++)
			{	
				average = average + this.candles.get(i).volume;
			}
		
			this.candles.get(j+candleCount).diffVolume = this.candles.get(j+candleCount).volume/(average/candleCount);
		}
	}
	
	public void setDiffOI(int candleCount)
	{
		double average;
		
		int j ;
		
		for(j = 0; j < this.candles.size()-candleCount;j++)
		{
			average = 0.0;
			
			for(int i = j ; i < j + candleCount ; i++)
			{	
				average = average + this.candles.get(i).openInterest;
			}
		
			this.candles.get(j+candleCount).diffOI = this.candles.get(j+candleCount).openInterest/(average/candleCount);
		}
	}
	*/
	


}
