package core.domain.realestate.offeringaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

@XmlRootElement
public class Representer implements IEntity, IArchivable {

	private int id;
    private int version;
	
    private boolean isArchived;
    private Date dateOfArchive;
	
	private String name;
	private String phone;
	private String email;
	private SellingOffer owner;
	private List<AvailableTime> availableTimes = new ArrayList<>();

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
    public boolean getIsArchived() {
		return isArchived;
	}
	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public Date getDateOfArchive() {
		return dateOfArchive;
	}
	public void setDateOfArchive(Date dateOfArchive) {
		this.dateOfArchive = dateOfArchive;
	}
	public List<AvailableTime> getAvailableTimes() {
		return availableTimes;
	}

	public void setAvailableTimes(List<AvailableTime> availableTimes) {
		this.availableTimes = availableTimes;
	}

	public SellingOffer getOwner() {
		return owner;
	}

	public void setOwner(SellingOffer owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void addAvailable(AvailableTime availableTime){
		availableTime.setOwner(this);
		this.availableTimes.add(availableTime);
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
