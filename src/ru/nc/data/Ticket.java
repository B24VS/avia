package ru.nc.data;
//class for describing tickets
public class Ticket {
	private long id;
	private long num;
	private long raceId;
	
	public Ticket (long tId,long tNum,long tRaceId){
		this.id = tId;
		this.num = tNum;
		this.raceId = tRaceId;
	}
	
	public long getId() {
		return id;
	}
	
	public long getNum() {
		return num;
	}
	
	public long getRaceId() {
		return raceId;
	}
	
}
