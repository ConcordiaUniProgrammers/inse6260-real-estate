package core.domain.realestate.estateaggregate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	
	private String street;
    private String postalCode;
    private String number;
    
    
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
