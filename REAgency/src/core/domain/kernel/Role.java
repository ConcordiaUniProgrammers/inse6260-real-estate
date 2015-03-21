package core.domain.kernel;

import java.util.Date;
import java.util.List;

public class Role implements IEntity,IArchivable {

	private int id;
    private int version;
    
    private boolean isArchived;
	private Date dateOfArchive;
	
	private RoleType roleType;
	private List<String> pages;
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
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public List<String> getPages() {
		return pages;
	}
	public void setPages(List<String> pages) {
		this.pages = pages;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
