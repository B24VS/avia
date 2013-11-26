package ru.nc.data;
public class Flight {
	private long id;
	private long num;
	private String destId;
	private String depId;
	
	public Flight(long fId, long fNum, String fDestId, String fDepId){
		this.id = fId;
		this.num = fNum;
		this.destId = fDestId;
		this.depId = fDepId;
	}
	
	public long getId() {
		return id;
	}

	public long getNum() {
		return num;
	}

	public String getDestId() {
		return destId;
	}


	public String getDepId() {
		return depId;
	}

	
	
	

}
