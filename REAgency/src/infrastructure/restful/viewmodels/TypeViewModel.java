package infrastructure.restful.viewmodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypeViewModel {
	private int id;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
