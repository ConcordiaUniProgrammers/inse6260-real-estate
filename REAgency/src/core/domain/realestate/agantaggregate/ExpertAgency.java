package core.domain.realestate.agantaggregate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.domain.kernel.IArchivable;
import core.domain.kernel.IEntity;
import core.domain.kernel.Role;
import core.domain.realestate.estateaggregate.Address;
import core.domain.realestate.estateaggregate.Estate;

public class ExpertAgency implements IEntity, IArchivable {

	private int id;
    private int version;
    
	private boolean isArchived;
	private Date dateOfArchive;
	private String name;
	private Address address;
	private String licence;
	private List<Estate> approvals = new ArrayList<>();
	private String email;
	private String phone;
	private String username;
	private String password;
	private Role role;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public List<Estate> getApprovals() {
		return approvals;
	}
	public void setApprovals(List<Estate> approvals) {
		this.approvals = approvals;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void addEstate(Estate estate){
		estate.setApprovedBy(this);
		this.approvals.add(estate);
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
