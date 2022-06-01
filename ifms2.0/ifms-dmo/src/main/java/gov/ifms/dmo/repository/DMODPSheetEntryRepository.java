package gov.ifms.dmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.dmo.entity.DMODPSheetEntryEntity;

/**
 * The Class DMODPSheetEntryRepository.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Repository
@Transactional
public interface DMODPSheetEntryRepository extends JpaRepository<DMODPSheetEntryEntity, Long>,
JpaSpecificationExecutor<DMODPSheetEntryEntity>{

}