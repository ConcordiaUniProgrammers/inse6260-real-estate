package core.domain.realestate.offeringaggregate;

import java.util.Date;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.kernel.User;

public class Offer implements IEntity, IArchivable {

	private int id;
    private int version;
	
    private boolean isArchived;
    private Date dateOfArchive;
    private User customer;
    private SellingOffer offerOwner;
    private int price;
    private OfferStatus offerStatus;
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
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public SellingOffer getOfferOwner() {
		return offerOwner;
	}
	public void setOfferOwner(SellingOffer offerOwner) {
		this.offerOwner = offerOwner;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public OfferStatus getOfferStatus() {
		return offerStatus;
	}
	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
