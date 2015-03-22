package core.domain.realestate.estateaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.realestate.agantaggregate.ExpertAgency;
import core.domain.realestate.areaaggregate.District;
import core.domain.realestate.offeringaggregate.SellingOffer;
import core.domain.realestate.typeaggregate.EstateType;

@XmlRootElement
public class Estate implements IEntity, IArchivable {

	private int id;
	private int version;

	private boolean isArchived;
	private Date dateOfArchive;

	private List<EstateFeature> features = new ArrayList<>();
	private List<NearbyFacility> nearbyFacilities = new ArrayList<>();
	private EstateType type;
	private Address address;
	private List<Unit> units = new ArrayList<>();
	private ExpertAgency approvedBy;
	private District area;
	private SellingOffer owner;
	private List<Image> images = new ArrayList<>();
	private String videoAddress;
    private String description;
    private int age;
    private Date renewDate;
	
	public int getId() {
		return id;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
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

	public List<EstateFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<EstateFeature> features) {
		this.features = features;
	}

	public EstateType getType() {
		return type;
	}

	public void setType(EstateType type) {
		this.type = type;
	}

	public List<NearbyFacility> getNearbyFacilities() {
		return nearbyFacilities;
	}

	public void setNearbyFacilities(List<NearbyFacility> nearbyFacilities) {
		this.nearbyFacilities = nearbyFacilities;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Unit> getUnit() {
		return units;
	}

	public void setUnit(List<Unit> unit) {
		this.units = unit;
	}

	public String getVideoAddress() {
		return videoAddress;
	}

	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}

	public ExpertAgency getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(ExpertAgency approvedBy) {
		this.approvedBy = approvedBy;
	}

	public District getArea() {
		return area;
	}

	public void setArea(District area) {
		this.area = area;
	}

	
	public SellingOffer getOwner() {
		return owner;
	}

	public void setOwner(SellingOffer owner) {
		this.owner = owner;
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	public void addUnits(Unit unit) {
		unit.setEstate(this);
		this.units.add(unit);
	}
	
	public void addImage(Image image) {
		image.setEstateOwner(this);
		this.images.add(image);
	}
	public void addEstateFeatures(EstateFeature estateFeature) {
		estateFeature.setOwner(this);
		this.features.add(estateFeature);
	}
	public void addNearbyFacilitys(NearbyFacility nearbyFacility) {
		nearbyFacility.setOwner(this);
		this.nearbyFacilities.add(nearbyFacility);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getRenewDate() {
		return renewDate;
	}

	public void setRenewDate(Date renew) {
		this.renewDate = renew;
	}


}
