/**
 * 
 */
package gov.ifms.doi.coinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.ifms.doi.coinsurance.entity.DoiCoinsClaimRiDtlEntity;

/**
 * @author Rudra
 *
 */
public interface DoiCoinsClaimRiDtlRepository extends JpaRepository<DoiCoinsClaimRiDtlEntity, Long>, JpaSpecificationExecutor<DoiCoinsClaimRiDtlEntity>{

}
