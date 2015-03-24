package core.domain.realestate.offeringaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.kernel.User;
import core.domain.realestate.agantaggregate.ExpertAgency;
import core.domain.realestate.estateaggregate.Estate;
import core.domain.realestate.typeaggregate.SellingOfferType;

@XmlRootElement
public class SellingOffer implements IEntity, IArchivable {

	private int id;
    private int version;
	
    private boolean isArchived;
    private Date dateOfArchive;
    private Estate estate;
    private User owner;
    private List<Representer> representers = new ArrayList<>();
    private List<Offer> offers = new ArrayList<>();
    private ExpertAgency approvalRequest;
    private ApprovalStatus approvalStatus;
    private Date dateOfApprove;
    private ExpertAgency offeredBy;
    private SellingOfferType type;
    private String description;
    private int basePrice;
    
    
    public SellingOffer() {
    	setEstate(new Estate());
	}

    public List<Representer> getRepresenters() {
		return representers;
	}

	public void setRepresenters(List<Representer> representers) {
		this.representers = representers;
	}

	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

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
	
	public Date getDateOfArchive() {
		return dateOfArchive;
	}
	public void setDateOfArchive(Date dateOfArchive) {
		this.dateOfArchive = dateOfArchive;
	}
	public Estate getEstate() {
		return estate;
	}
	public void setEstate(Estate estate) {
		this.estate = estate;
		estate.setOwner(this);
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public ExpertAgency getApprovalRequest() {
		return approvalRequest;
	}
	public void setApprovalRequest(ExpertAgency approvalRequest) {
		this.approvalRequest = approvalRequest;
	}
	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Date getDateOfApprove() {
		return dateOfApprove;
	}
	public void setDateOfApprove(Date dateOfApprove) {
		this.dateOfApprove = dateOfApprove;
	}
	public ExpertAgency getOfferedBy() {
		return offeredBy;
	}
	public void setOfferedBy(ExpertAgency offeredBy) {
		this.offeredBy = offeredBy;
	}
	public void addOffer(Offer offer){
		offer.setOfferOwner(this);
		this.offers.add(offer);
	}
	public void addRepresenter(Representer representer){
		representer.setOwner(this);
		this.representers.add(representer);
	}
	public SellingOfferType getType() {
		return type;
	}
	public void setType(SellingOfferType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

}
