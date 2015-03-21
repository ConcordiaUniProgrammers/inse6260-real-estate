package core.domain.realestate.estateaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;

public class Unit implements IEntity, IArchivable {

	private int id;
	private int version;

	private boolean isArchived;
	private Date dateOfArchive;

	private List<Image> images = new ArrayList<>();
	private String videoAddress;
	private List<Piece> pieces = new ArrayList<>();
	private Estate estate;
	private List<Appliance> appliances = new ArrayList<>();
	private int floorNumber;
	private int unitNumber;
    private String description;
    private Date internalRenewDate;

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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getVideoAddress() {
		return videoAddress;
	}

	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	public List<Appliance> getAppliances() {
		return appliances;
	}

	public void setAppliances(List<Appliance> appliances) {
		this.appliances = appliances;
	}

	public void addAppliance(Appliance appliance) {
		appliance.setOwner(this);
		this.appliances.add(appliance);

	}

	public void addPiece(Piece piece) {
		piece.setOwner(this);
		this.pieces.add(piece);
	}

	public void addImage(Image image) {
		image.setOwner(this);
		this.images.add(image);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInternalRenewDate() {
		return internalRenewDate;
	}

	public void setInternalRenewDate(Date internalRenewDate) {
		this.internalRenewDate = internalRenewDate;
	}

}
