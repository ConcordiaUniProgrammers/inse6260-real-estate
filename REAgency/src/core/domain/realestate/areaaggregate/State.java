package core.domain.realestate.areaaggregate;

import java.util.ArrayList;
import java.util.List;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public class State implements IEntity {

	private int id;
    private int version;
    

	private String name;
	private Country country;
	private List<City> cities = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public void addCity(City city){
		city.setState(this);
		this.cities.add(city);
	}
	
}
