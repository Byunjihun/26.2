package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.MemberImage;
import hannamproject.hanpro.repository.MemberImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberImageService {

    private final MemberImageRepository memberImageRepository;

    public Optional<String> getImagePathByStudentId(String studentId) {
        return memberImageRepository.findByStudentId(studentId).map(MemberImage::getImagePath);
    }

    public void saveMemberImage(String studentId, String imagePath) {
        MemberImage memberImage = new MemberImage();
        memberImage.setStudentId(studentId);
        memberImage.setImagePath(imagePath);
        memberImageRepository.save(memberImage);
    }
}
