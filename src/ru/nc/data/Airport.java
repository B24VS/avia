package ru.nc.data;
// class for describing airports
public class Airport {
	private Long airportId;
	private Long locationId;
	private String name;
	
	public Airport(long aId, long lId, String aName){
		this.airportId = aId;
		this.locationId = lId;
                this.name = aName;
	}

	public Long getAirportId() {
		return airportId;
	}

	
	public Long getLocationId() {
		return locationId;
	}	
        
        public String getAirportName(){
            return name;
        }

}
