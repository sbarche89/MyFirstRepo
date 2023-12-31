package model;

import java.util.List;

public class WatchList {
	
	private String id;
	
	private String name;
	
	private List<Item> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
