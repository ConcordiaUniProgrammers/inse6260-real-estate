package test.infrastructure.hib;

import static org.junit.Assert.assertNotNull;
import infrastructure.hib.DIConfiguration;
import infrastructure.hib.UnitOfWork;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
import core.contract.infracontract.IUnitOfWork;
import core.contract.infracontract.IUnitRepository;
import core.contract.infracontract.IUserRepository;
import core.domain.realestate.typeaggregate.EstateType;

public class UnitOfWorkTest {
	private AnnotationConfigApplicationContext context;
	private IUnitOfWork uow;

	@Before
	public void setUp() throws Exception {
		try {
			 this.context = new AnnotationConfigApplicationContext(DIConfiguration.class);
			 this.uow = context.getBean(UnitOfWork.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@After
	public void tearDown() throws Exception {
		this.context.close();
	}

	@Test
	public void getCityRepositoryTest() {
		ICityRepository repo = this.uow.getCityRepository();
		assertNotNull(repo);
	}
	@Test
	public void getRoleRepositoryTest() {
		IRoleRepository repo = this.uow.getRoleRepository();
		assertNotNull(repo);
	}
	@Test
	public void getUserRepositoryTest() {
		IUserRepository repo = this.uow.getUserRepository();
		assertNotNull(repo);
	}
	@Test
	public void getExpertAgencyRepositoryTest() {
		IExpertAgencyRepository repo = this.uow.getExpertAgencyRepository();
		assertNotNull(repo);
	}
	@Test
	public void getCountryRepositoryTest() {
		ICountryRepository repo = this.uow.getCountryRepository();
		assertNotNull(repo);
	}
	@Test
	public void getDistrictRepositoryTest() {
		IDistrictRepository repo = this.uow.getDistrictRepository();
		assertNotNull(repo);
	}
	@Test
	public void getStateRepositoryTest() {
		IStateRepository repo = this.uow.getStateRepository();
		assertNotNull(repo);
	}
	@Test
	public void getApplianceRepositoryTest() {
		IApplianceRepository repo = this.uow.getApplianceRepository();
		assertNotNull(repo);
	}
	@Test
	public void getEstateRepositoryTest() {
		IEstateRepository repo = this.uow.getEstateRepository();
		assertNotNull(repo);
	}
	@Test
	public void getEstateFeatureRepositoryTest() {
		IEstateFeatureRepository repo = this.uow.getEstateFeatureRepository();
		assertNotNull(repo);
	}
	@Test
	public void getImageRepositoryTest() {
		IImageRepository repo = this.uow.getImageRepository();
		assertNotNull(repo);
	}
	@Test
	public void getNearbyFacilityRepositoryTest() {
		INearbyFacilityRepository repo = this.uow.getNearbyFacilityRepository();
		assertNotNull(repo);
	}
	@Test
	public void getPieceRepositoryTest() {
		IPieceRepository repo = this.uow.getPieceRepository();
		assertNotNull(repo);
	}
	@Test
	public void getUnitRepositoryTest() {
		IUnitRepository repo = this.uow.getUnitRepository();
		assertNotNull(repo);
	}
	@Test
	public void getAvailableTimeRepositoryTest() {
		IAvailableTimeRepository repo = this.uow.getAvailableTimeRepository();
		assertNotNull(repo);
	}
	@Test
	public void getBookedTimeRepositoryTest() {
		IBookedTimeRepository repo = this.uow.getBookedTimeRepository();
		assertNotNull(repo);
	}
	@Test
	public void getOfferRepositoryTest() {
		IOfferRepository repo = this.uow.getOfferRepository();
		assertNotNull(repo);
	}
	@Test
	public void getRepresenterRepositoryTest() {
		IRepresenterRepository repo = this.uow.getRepresenterRepository();
		assertNotNull(repo);
	}
	@Test
	public void getSellingOfferRepositoryTest() {
		ISellingOfferRepository repo = this.uow.getSellingOfferRepository();
		assertNotNull(repo);
	}
	@Test
	public void getrETypeRepositoryTest() {
		IRETypeRepository repo = this.uow.getrETypeRepository();
		EstateType t = new EstateType();
		t.setName("dddd");
		repo.save(t);
		assertNotNull(repo);
	}
	
}
