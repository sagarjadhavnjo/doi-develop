package gov.ifms.pvu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;

@Repository
@Transactional
public interface PVUCsAttachmentRepository extends BasePVUAttachmentRepository<PVUCsAttachmentsEntity> {

	List<PVUCsAttachmentsEntity> findAllByChangeOfScaleIdAndActiveStatus(Long referenceId, int activeStatus);

	@Modifying(clearAutomatically = true)
	@Query("update PVUCsAttachmentsEntity entity set entity.activeStatus = :activeStatus where entity.id = :id")
	void updateStatusAsDelete(@Param("id") Long id, @Param("activeStatus") int activeStatus);
}
