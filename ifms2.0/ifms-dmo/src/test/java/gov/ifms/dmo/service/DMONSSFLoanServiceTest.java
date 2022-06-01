package gov.ifms.dmo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.dmo.constant.JunitConstants;
import gov.ifms.dmo.converter.DMONSSFLoanConverter;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.service.impl.DMONSSFLoanServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class DMONSSFLoanServiceTest {

	@InjectMocks
	private DMONSSFLoanServiceImpl service;

	@Mock
	DMONSSFLoanRepository repository;

	@Mock
	DMONSSFLoanConverter converter;

	/** The entity. */
	@Mock
	private DMONSSFLoanEntity entity;

	/** The entities. */
	@Mock
	private List<DMONSSFLoanEntity> entities;

	/** The page detail. */
	@Mock
	private PageDetails pageDetail;

	/** The pageable. */
	@Mock
	private PageRequest pageable;

	/** The spec. */
	@Mock
	private SpecificationImpl<DMONSSFLoanEntity> spec;

	/** The search criteria. */
	@Mock
	private SearchCriteria searchCriteria;

	/** The page. */
	@Mock
	private Page<DMONSSFLoanEntity> page;

	@Mock
	DMODPSheetEntryRepository dpSheetRepository;

	/** The pageble dto. */
	@Mock
	private PagebleDTO<DMONSSFLoanPostDto> pagebleDto;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test get NSSF Loan findById Success.
	 */
	@Test
	@DisplayName("Test NSSF Loan findById Success")
	void testFindById() {
		DMONSSFLoanPostDto dto = new DMONSSFLoanPostDto();
		dto.setAdviceBy("test");
		when(repository.getOne(JunitConstants.LONG_TYPE)).thenReturn(entity);
		when(converter.toDTO(entity)).thenReturn(dto);
		DMONSSFLoanPostDto response = service.getNSSFLoanReceived(JunitConstants.LONG_TYPE);
		assertEquals("test", response.getAdviceBy());

	}

	/**
	 * Test save NSSF Loan save Success.
	 *//*
		 * @Test
		 * 
		 * @DisplayName("Test NSSF Loan save Success") void save() { DMONSSFLoanPostDto
		 * dto = new DMONSSFLoanPostDto(); dto.setAdviceBy("test");
		 * when(converter.toEntity(dto)).thenReturn(entity);
		 * when(repository.save(entity)).thenReturn(entity);
		 * when(converter.toDTO(entity)).thenReturn(dto); DMONSSFLoanPostDto response =
		 * service.saveOrUpdateNSSFLoanReceived(dto);
		 * assertEquals("test",response.getAdviceBy());
		 * 
		 * }
		 */

	/**
	 * Test dmo NSFF module as method name search.
	 *
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test NSSF Loan findAll Success")
	void getNSSFLoanApprovedList_success() throws CustomException {
		when(pageDetail.getPageDetails(pageDetail)).thenReturn(pageable);
		SearchParam searchParam = new SearchParam();
		searchParam.setKey(JunitConstants.STRING_TYPE);
		searchParam.setValue(JunitConstants.STRING_TYPE);
		List<SearchParam> list = new ArrayList<SearchParam>();
		list.add(searchParam);
		when(pageDetail.getJsonArr()).thenReturn(list);
		when(searchCriteria.getSpecificationDetails(spec, list)).thenReturn(spec);
		when(repository.findAll(Mockito.any(SpecificationImpl.class), Mockito.any(PageRequest.class))).thenReturn(page);
		assertNotNull(service.getNSSFLoanApprovedList(pageDetail));

	}

}
