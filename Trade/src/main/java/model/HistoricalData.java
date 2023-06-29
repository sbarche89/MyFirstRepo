package model;

import java.util.List;

public class HistoricalData {
	
	public String status;
	
	public Candles data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Candles getData() {
		return data;
	}

	public void setData(Candles data) {
		this.data = data;
	}
}
