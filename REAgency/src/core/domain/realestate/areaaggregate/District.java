package core.domain.realestate.areaaggregate;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IEntity;

@XmlRootElement
public class District implements IEntity {

	private int id;
    private int version;
    
	private String name;
	private City city;
	
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

}
