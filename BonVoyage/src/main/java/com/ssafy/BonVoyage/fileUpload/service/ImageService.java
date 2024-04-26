package com.ssafy.BonVoyage.fileUpload.service;



import com.ssafy.BonVoyage.fileUpload.domain.ProfileImage;
import com.ssafy.BonVoyage.fileUpload.dto.ProfileImageDto;
import com.ssafy.BonVoyage.fileUpload.repository.ProfileImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class ImageService {

    private ProfileImageRepository profileImageRepository;

    public String saveMember(ProfileImageDto profileImageDto) {
        ProfileImage save = profileImageRepository.save(profileImageDto.toEntity());
        String imageUrl = save.getFilePath();
        return imageUrl;
    }

    public List<ProfileImageDto> getList() {
        List<ProfileImage> profileImageList = profileImageRepository.findAll();
        List<ProfileImageDto> profileImageDtoList = new ArrayList<>();

        for (ProfileImage profileImage : profileImageList) {
            profileImageDtoList.add(convertEntityToDto(profileImage));
        }

        return profileImageDtoList;
    }

    private ProfileImageDto convertEntityToDto(ProfileImage profileImage) {
        return ProfileImageDto.builder()
                .id(profileImage.getId())
                .imgFullPath(profileImage.getFilePath())
                .build();
    }

    @Transactional
    public void delete(Long galleryId) {
        ProfileImage gallery = profileImageRepository.findById(galleryId).orElseThrow(() ->
                new IllegalArgumentException("해당 이미지가 존재하지 않습니다. id=" + galleryId));

        profileImageRepository.delete(gallery);
    }

    @Transactional
    public ProfileImageDto read(Long galleryId) {
        ProfileImage gallery = profileImageRepository.findById(galleryId).orElseThrow(() ->
                new IllegalArgumentException("해당 이미지가 존재하지 않습니다. id=" + galleryId));

        ProfileImageDto profileImageDto = convertEntityToDto(gallery);
        return profileImageDto;
    }
}
