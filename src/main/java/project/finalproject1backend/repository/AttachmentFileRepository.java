package project.finalproject1backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.finalproject1backend.domain.AttachmentFile;
import project.finalproject1backend.domain.User;

import java.util.List;

public interface AttachmentFileRepository extends JpaRepository<AttachmentFile,Long> {
    void deleteByFileName(String fileName);
    void deleteAllByUserBusinessLicense(Long id);
    List<AttachmentFile> findByUserAdditionalData(User user);
}
