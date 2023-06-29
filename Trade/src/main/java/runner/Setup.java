package runner;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import algo.OILowHighIndicator;
import algo.VolumeLowHighIndicator;
import algo.VolumeOICompareIndicator;
import kiteApis.Historical;
import kiteApis.MarketWatch;
import strategy.CandleModel;
import strategy.Stock;

public class Setup {
	
	String date = "2023-06-23";
	
	String future = "23JULFUT";
	
	MarketWatch marketWatch ;
	
	VolumeOICompareIndicator volumeOiIndicator;
	
	VolumeLowHighIndicator volumeLowHighIndicator;
	
	OILowHighIndicator oiLowHighIndicator;
	
	
	public Setup() throws IOException {
	
		this.marketWatch = new MarketWatch();
		
		volumeOiIndicator = new VolumeOICompareIndicator();
		
		volumeLowHighIndicator = new VolumeLowHighIndicator();
		
		oiLowHighIndicator = new OILowHighIndicator();
		
		marketWatch.setStocks();
	}
	
	public void run()
	{	
		this.marketWatch.getStocks().stream().filter(e -> !e.name.contains(future)).
		forEach(e -> volumeLowHighIndicator.getIntrdaySignals(e,date));
		//volumeLowHighIndicator.getIntrdaySignals(this.marketWatch.getStocks().get(0), date);
	}
	
	public void deRun()
	{
		//System.out.println("---------------OI Volume Indicator------------"+ DateTime.now());
		
				this.marketWatch.getStocks().stream().filter(e -> !e.name.contains(future)).forEach(e -> volumeOiIndicator.getIntrdaySignals(e,this.marketWatch.getStockByName(e.name + future), date));
				
				//System.out.println("---------------Volume Indicator on stocks------------"+ DateTime.now());
				
				//this.marketWatch.getStocks().stream().filter(e -> !e.name.contains(future)).forEach(e -> volumeLowHighIndicator.getIntrdaySignals(e,date));
				
				//volumeLowHighIndicator.getIntrdaySignals(this.marketWatch.getStocks().get(9),date);

				
				//System.out.println("---------------OI Indicator on Futures------------"+ DateTime.now());
				
				//this.marketWatch.getStocks().stream().filter(e -> !e.name.contains(future)).forEach(e -> oiLowHighIndicator.getIntrdaySignals(this.marketWatch.getStockByName(e.name + future),date));
				
				//System.out.println("---------------END------------"+DateTime.now());
	}
	
	public void runScheduler()
	{
		try {
		
		run();
		
		} catch(Exception e)
		{
			
		}		
	}
	

	public static void main(String args[]) throws IOException, InterruptedException 
	{	
		Setup setup = new Setup();
		
		setup.runScheduler();
		
	}
}
