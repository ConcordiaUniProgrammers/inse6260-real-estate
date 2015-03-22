package core.domain.realestate.areaaggregate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

@XmlRootElement
public class City implements IEntity {

	private int id;
    private int version;
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
	private String name;
	private State state;
	private List<District> districts = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	public void addDistrict(District district){
		district.setCity(this);
		this.districts.add(district);
	}
	

}
