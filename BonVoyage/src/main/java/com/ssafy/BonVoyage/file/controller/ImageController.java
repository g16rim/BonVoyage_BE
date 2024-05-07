package com.ssafy.BonVoyage.file.controller;

import com.ssafy.BonVoyage.file.dto.ProfileImageDto;
import com.ssafy.BonVoyage.file.service.ImageService;
import com.ssafy.BonVoyage.file.service.S3Service;
import com.ssafy.BonVoyage.auth.config.security.token.CurrentUser;
import com.ssafy.BonVoyage.auth.config.security.token.UserPrincipal;
import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.ssafy.BonVoyage.file.service.S3Service.CLOUD_FRONT_DOMAIN_NAME;


@Slf4j
@RestController
@AllArgsConstructor
@Tag(name="Image Upload", description = "프로필 이미지 저장 api")
@RequestMapping("/api")
public class ImageController {
    private S3Service s3Service;
    private ImageService imageService;
    private final MemberRepository memberRepository;

    @Operation(method = "get", summary = "모든 이미지 조회")
    @ApiResponses(value=
    @ApiResponse(responseCode = "200", description = "이미지 조회 성공")
    )
    @GetMapping("/profileImg")
    public List<ProfileImageDto> dispWrite() {
        List<ProfileImageDto> profileImageDtoList = imageService.getList();
        return profileImageDtoList;
    }

    @PostMapping(path= "/profileImg", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(method = "post", summary = "이미지 등록")
    @ApiResponse(responseCode = "200", description = "이미지 등록 성공")
    public ResponseEntity<String> execWrite(@RequestPart(value="file",required = false)  MultipartFile file) throws IOException {

        ProfileImageDto profileImageDto = new ProfileImageDto();
        String imgPath = s3Service.upload(file);

        profileImageDto.setImgFullPath(CLOUD_FRONT_DOMAIN_NAME+"/"+imgPath);

        return ResponseEntity.ok(imageService.saveMember(profileImageDto));
    }


    @Operation(method="get", summary = "해당 이미지 조회")
    @ApiResponses(value=
    @ApiResponse(responseCode = "200", description = "해당 이미지 조회 성공")
    )
    @GetMapping("/profileImg/{profileImgId}")
    public ProfileImageDto read(@PathVariable Long profileImgId){
        ProfileImageDto read = imageService.read(profileImgId);
        return read;
    }

    @Operation(method="delete", summary = "이미지 삭제")
    @ApiResponses(value=
    @ApiResponse(responseCode = "200", description = "이미지 삭제 성공")
    )
    @DeleteMapping("/profileImg/{profileImgId}")
    public ResponseEntity<?> delete(@PathVariable Long profileImgId){
        imageService.delete(profileImgId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(method="update", summary = "이미지 수정")
    @ApiResponses(value=
    @ApiResponse(responseCode = "200", description = "이미지 수정 성공")
    )
    @PutMapping("/profileImg")
    public ResponseEntity<?> delete(@CurrentUser UserPrincipal userPrincipal, @RequestPart(value="file",required = false)  MultipartFile file) throws IOException {
        Member member = memberRepository.findById(userPrincipal.getId()).get();
        ProfileImageDto profileImageDto = new ProfileImageDto();
        String imgPath = s3Service.upload(file);
        profileImageDto.setImgFullPath(CLOUD_FRONT_DOMAIN_NAME+"/"+imgPath);
        String s = imageService.saveMember(profileImageDto);
        memberRepository.updateImageUrl(member.getId(), s);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

