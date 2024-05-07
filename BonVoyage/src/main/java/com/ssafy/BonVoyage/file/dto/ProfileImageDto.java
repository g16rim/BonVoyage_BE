package com.ssafy.BonVoyage.file.dto;




import com.ssafy.BonVoyage.file.domain.ProfileImage;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProfileImageDto {
    private Long id;
    private String title;
    private String imgFullPath;

    public ProfileImage toEntity(){
        return ProfileImage.builder()
                .id(id)
                .filePath(imgFullPath)
                .build();
    }


}
