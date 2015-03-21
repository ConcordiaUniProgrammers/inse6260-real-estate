package core.domain.realestate.estateaggregate;

import java.util.Date;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public class Appliance implements IEntity, IArchivable {

	private int id;
    private int version;

    private boolean isArchived;
    private Date dateOfArchive;
    
	private int quantity;
	private ApplianceType type;
	private Unit owner;
    private String description;
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ApplianceType getType() {
		return type;
	}
	public void setType(ApplianceType type) {
		this.type = type;
	}
	public Unit getOwner() {
		return owner;
	}
	public void setOwner(Unit owner) {
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}