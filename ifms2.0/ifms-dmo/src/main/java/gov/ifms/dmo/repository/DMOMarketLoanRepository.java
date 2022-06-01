package gov.ifms.dmo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.ifms.dmo.dao.GenericDao;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;

@Repository
@Transactional
public interface DMOMarketLoanRepository extends JpaRepository<DMOMarketLoanEntity, Long>, GenericDao,
JpaSpecificationExecutor<DMOMarketLoanEntity>{

}
