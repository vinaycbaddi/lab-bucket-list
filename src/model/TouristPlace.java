package model;

public class TouristPlace{
	String name;
	String destination;
	String rank;
	public TouristPlace(String name, String destination, String rank) {
		super();
		this.name = name;
		this.destination = destination;
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}