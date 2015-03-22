package infrastructure.restful.viewmodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypeViewModel {
	private String type;
	private String newTypeName;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNewTypeName() {
		return newTypeName;
	}
	public void setNewTypeName(String newTypeName) {
		this.newTypeName = newTypeName;
	}

}
