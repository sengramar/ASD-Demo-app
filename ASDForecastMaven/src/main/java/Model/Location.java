package Model;



public class Location {
    private int LocationID;
    private String Country, State, Region;

    public Location(int LocationID, String Country, String State, String Region) {
        this.LocationID = LocationID;
        this.Country = Country;
        this.State = State;
        this.Region = Region;
    }

    public int getLocationID() {
        return LocationID;
    }

    public void setLocationID(int LocationID) {
        this.LocationID = LocationID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }
    
}