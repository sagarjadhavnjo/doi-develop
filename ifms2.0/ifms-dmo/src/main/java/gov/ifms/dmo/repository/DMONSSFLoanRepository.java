package gov.ifms.dmo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;

@Repository
@Transactional
public interface DMONSSFLoanRepository
		extends JpaRepository<DMONSSFLoanEntity, Long>, GenericDao, JpaSpecificationExecutor<DMONSSFLoanEntity> {

}
