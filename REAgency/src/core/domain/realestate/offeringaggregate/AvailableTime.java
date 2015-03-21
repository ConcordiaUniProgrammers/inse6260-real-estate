package core.domain.realestate.offeringaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public class AvailableTime implements IEntity, IArchivable {

	private int id;
    private int version;
	
    private boolean isArchived;
    private Date dateOfArchive;
    
	private List<BookedTime> bookedTimes = new ArrayList<>();
	private Representer owner;
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
	public List<BookedTime> getBookedTimes() {
		return bookedTimes;
	}

	public void setBookedTimes(List<BookedTime> bookedTimes) {
		this.bookedTimes = bookedTimes;
	}

	public Representer getOwner() {
		return owner;
	}

	public void setOwner(Representer owner) {
		this.owner = owner;
	}
	public void addBookedTime(BookedTime bookedTime){
		bookedTime.setOwner(this);
		this.bookedTimes.add(bookedTime);
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
