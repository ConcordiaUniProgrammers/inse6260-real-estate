package core.domain.realestate.typeaggregate;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

@XmlRootElement
public class REType implements IEntity, IArchivable {

	private int id;
    private int version;
    
	private String name;
	private String accessKey;
	private int rank;
	private boolean isArchived;
	private Date dateOfArchive;
	
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
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
