package ru.nc.data;
//class for describing planes
public class Plane {
	private long id;
	private String name;
	private String model;
	
	public Plane(long pId, String pName, String pModel){
		this.id = pId;
		this.name = pName;
		this.model = pModel;
	}
	
	
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getModel() {
		return model;
	}
}
	