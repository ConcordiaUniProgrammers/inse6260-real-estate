package core.domain.realestate.areaaggregate;

import java.util.ArrayList;
import java.util.List;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public class Country implements IEntity {

	private int id;
    private int version;
    
	private String name;
	private List<State> states = new ArrayList<>();

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

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	public void addState(State state){
		state.setCountry(this);
		this.states.add(state);
	}

}
