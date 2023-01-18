package uz.pdp.payment_task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.payment_task.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {

    Optional<AttachmentContent> findByAttachmentId(Integer attachment_id);

}
