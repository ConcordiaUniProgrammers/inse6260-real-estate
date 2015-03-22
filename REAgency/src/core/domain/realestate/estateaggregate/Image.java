package core.domain.realestate.estateaggregate;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.realestate.typeaggregate.ImageType;

@XmlRootElement
public class Image implements IEntity, IArchivable {

	private int id;
    private int version;
    
	private boolean isArchived;
    private Date dateOfArchive;
    private ImageType type;
    private String imageAddress;
    private Unit owner;
    private Estate estateOwner;
    
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
	public ImageType getType() {
		return type;
	}
	public void setType(ImageType type) {
		this.type = type;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	public Unit getOwner() {
		return owner;
	}
	public void setOwner(Unit owner) {
		this.owner = owner;
	}
	public Estate getEstateOwner() {
		return estateOwner;
	}
	public void setEstateOwner(Estate estateOwner) {
		this.estateOwner = estateOwner;
	}
}
