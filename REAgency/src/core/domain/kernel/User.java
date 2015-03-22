package core.domain.kernel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import core.domain.realestate.estateaggregate.Address;
import core.domain.realestate.offeringaggregate.BookedTime;
import core.domain.realestate.offeringaggregate.Offer;
import core.domain.realestate.offeringaggregate.SellingOffer;

@XmlRootElement
public class User implements IEntity, IArchivable {

	private int id;
    private int version;
    
	private boolean isArchived;
	
	private Date dateOfArchive;
	
	private String name;
	private Address address;
	private List<SellingOffer> sellingOffers = new ArrayList<>();
	private List<Offer> offers = new ArrayList<>();
	private List<SellingOffer> favorites = new ArrayList<>();
	private String email;
	private String phone;
	private List<BookedTime> bookedTimes = new ArrayList<>();
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
	public List<SellingOffer> getSellingOffers() {
		return sellingOffers;
	}
	public void setSellingOffers(List<SellingOffer> sellingOffers) {
		this.sellingOffers = sellingOffers;
	}
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public void addSellingOffer(SellingOffer sellingOffer){
		sellingOffer.setOwner(this);
		this.sellingOffers.add(sellingOffer);
	}
	public void addOffer(Offer offer){
		offer.setCustomer(this);
		this.offers.add(offer);
	}
	public List<BookedTime> getBookedTimes() {
		return bookedTimes;
	}
	public void setBookedTimes(List<BookedTime> bookedTimes) {
		this.bookedTimes = bookedTimes;
	}
	public void addBookedTime(BookedTime bookedTime){
		bookedTime.setCustomer(this);
		this.bookedTimes.add(bookedTime);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<SellingOffer> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<SellingOffer> favorites) {
		this.favorites = favorites;
	}
}
