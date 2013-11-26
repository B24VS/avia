package ru.nc.data;
// description of towns
public class Town {
	private Long id;
	private String name;
	
	public Town(long tId, String tName){
		this.id = tId;
		this.name = tName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	

}
