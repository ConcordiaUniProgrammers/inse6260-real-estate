package infrastructure.hib;

import infrastructure.hib.repo.imp.ApplianceRepository;
import infrastructure.hib.repo.imp.AvailableTimeRepository;
import infrastructure.hib.repo.imp.BookedTimeRepository;
import infrastructure.hib.repo.imp.CityRepository;
import infrastructure.hib.repo.imp.CountryRepository;
import infrastructure.hib.repo.imp.DistrictRepository;
import infrastructure.hib.repo.imp.EstateFeatureRepository;
import infrastructure.hib.repo.imp.EstateRepository;
import infrastructure.hib.repo.imp.ExpertAgencyRepository;
import infrastructure.hib.repo.imp.ImageRepository;
import infrastructure.hib.repo.imp.NearbyFacilityRepository;
import infrastructure.hib.repo.imp.OfferRepository;
import infrastructure.hib.repo.imp.PieceRepository;
import infrastructure.hib.repo.imp.RETypeRepository;
import infrastructure.hib.repo.imp.RepresenterRepository;
import infrastructure.hib.repo.imp.RoleRepository;
import infrastructure.hib.repo.imp.SellingOfferRepository;
import infrastructure.hib.repo.imp.StateRepository;
import infrastructure.hib.repo.imp.UnitRepository;
import infrastructure.hib.repo.imp.UserRepository;

import org.hibernate.criterion.Distinct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import core.contract.infracontract.IApplianceRepository;
import core.contract.infracontract.IAvailableTimeRepository;
import core.contract.infracontract.IBookedTimeRepository;
import core.contract.infracontract.ICityRepository;
import core.contract.infracontract.ICountryRepository;
import core.contract.infracontract.IDistrictRepository;
import core.contract.infracontract.IEstateFeatureRepository;
import core.contract.infracontract.IEstateRepository;
import core.contract.infracontract.IExpertAgencyRepository;
import core.contract.infracontract.IImageRepository;
import core.contract.infracontract.INearbyFacilityRepository;
import core.contract.infracontract.IOfferRepository;
import core.contract.infracontract.IPieceRepository;
import core.contract.infracontract.IRETypeRepository;
import core.contract.infracontract.IRepresenterRepository;
import core.contract.infracontract.IRoleRepository;
import core.contract.infracontract.ISellingOfferRepository;
import core.contract.infracontract.IStateRepository;
import core.contract.infracontract.IUnitRepository;
import core.contract.infracontract.IUserRepository;
import core.domain.kernel.Role;
import core.domain.kernel.User;
import core.domain.realestate.agantaggregate.ExpertAgency;
import core.domain.realestate.areaaggregate.City;
import core.domain.realestate.areaaggregate.Country;
import core.domain.realestate.areaaggregate.State;
import core.domain.realestate.estateaggregate.Appliance;
import core.domain.realestate.estateaggregate.Estate;
import core.domain.realestate.estateaggregate.EstateFeature;
import core.domain.realestate.estateaggregate.Image;
import core.domain.realestate.estateaggregate.NearbyFacility;
import core.domain.realestate.estateaggregate.Piece;
import core.domain.realestate.estateaggregate.Unit;
import core.domain.realestate.offeringaggregate.AvailableTime;
import core.domain.realestate.offeringaggregate.BookedTime;
import core.domain.realestate.offeringaggregate.Offer;
import core.domain.realestate.offeringaggregate.Representer;
import core.domain.realestate.offeringaggregate.SellingOffer;
import core.domain.realestate.typeaggregate.REType;

@Configuration
@ComponentScan(value={"infrastructure.hib"})
public class DIConfiguration {
    
    @Bean
    public ICityRepository getCityRepository(){
    	return new CityRepository(City.class);
    }
    @Bean
    public IRoleRepository getRoleRepository() {
		return new RoleRepository(Role.class);
	}
    @Bean
	public IUserRepository getUserRepository() {
		return new UserRepository(User.class);
	}
    @Bean
	public IExpertAgencyRepository getExpertAgencyRepository() {
		return new ExpertAgencyRepository(ExpertAgency.class);
	}
    @Bean
	public ICountryRepository getCountryRepository() {
		return new CountryRepository(Country.class);
	}
    @Bean
	public IDistrictRepository getDistrictRepository() {
		return new DistrictRepository(Distinct.class);
	}
    @Bean
	public IStateRepository getStateRepository() {
		return new StateRepository(State.class);
	}
    @Bean
	public IApplianceRepository getApplianceRepository() {
		return new ApplianceRepository(Appliance.class);
	}
    @Bean
	public IEstateRepository getEstateRepository() {
		return new EstateRepository(Estate.class);
	}
    @Bean
	public IEstateFeatureRepository getEstateFeatureRepository() {
		return new EstateFeatureRepository(EstateFeature.class);
	}
    @Bean
	public IImageRepository getImageRepository() {
		return new ImageRepository(Image.class);
	}
    @Bean
	public INearbyFacilityRepository getNearbyFacilityRepository() {
		return new NearbyFacilityRepository(NearbyFacility.class);
	}
    @Bean
	public IPieceRepository getPieceRepository() {
		return new PieceRepository(Piece.class);
	}
    @Bean
	public IUnitRepository getUnitRepository() {
		return new UnitRepository(Unit.class);
	}
    @Bean
	public IAvailableTimeRepository getAvailableTimeRepository() {
		return new AvailableTimeRepository(AvailableTime.class);
	}
    @Bean
	public IBookedTimeRepository getBookedTimeRepository() {
		return new BookedTimeRepository(BookedTime.class);
	}
    @Bean
	public IOfferRepository getOfferRepository() {
		return new OfferRepository(Offer.class);
	}
    @Bean
	public IRepresenterRepository getRepresenterRepository() {
		return new RepresenterRepository(Representer.class);
	}
    @Bean
	public ISellingOfferRepository getSellingOfferRepository() {
		return new SellingOfferRepository(SellingOffer.class);
	}
    @Bean
	public IRETypeRepository getrETypeRepository() {
		return new RETypeRepository(REType.class);
	}

}
