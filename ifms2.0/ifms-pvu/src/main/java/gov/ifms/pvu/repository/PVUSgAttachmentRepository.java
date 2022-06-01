package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUSgAttachmentEntity;

/**
 * The Class PVUSgAttachmentController.
 *
 * @version v 1.0
 * @created 2019/12/19 18:51:39
 */

@Repository
@Transactional
public interface PVUSgAttachmentRepository extends BasePVUAttachmentRepository<PVUSgAttachmentEntity> {

	List<PVUSgAttachmentEntity> findAllByIdAndActiveStatus(Long referenceId, int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUSgAttachmentEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
	void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);

	List<PVUSgAttachmentEntity> findAllBySgEntityIdAndActiveStatus(Long id, int activeStatus);

}
