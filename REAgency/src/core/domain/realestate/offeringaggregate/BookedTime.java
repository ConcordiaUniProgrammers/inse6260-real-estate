package core.domain.realestate.offeringaggregate;

import java.util.Date;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.kernel.User;

public class BookedTime implements IEntity, IArchivable {

	private int id;
    private int version;
	
    private boolean isArchived;
    private Date dateOfArchive;
    
	private User customer;
	private AvailableTime owner;
	private Date start;
	private Date end;

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
	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public AvailableTime getOwner() {
		return owner;
	}

	public void setOwner(AvailableTime owner) {
		this.owner = owner;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

}
