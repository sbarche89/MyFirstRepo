package model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MarketWatchList {
	
	private String status;
	
	public List<WatchList> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<WatchList> getData() {
		return data;
	}

	public void setData(List<WatchList> data) {
		this.data = data;
	}
	
	public List<String> fetchAllpIds()
	{
		return getData().stream().flatMap(e -> e.getItems().stream().map(x -> x.getInstrument_token()))
		.collect(Collectors.toList());
		
	}
}
