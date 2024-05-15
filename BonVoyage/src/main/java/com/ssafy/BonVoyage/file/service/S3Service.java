package com.ssafy.BonVoyage.file.service;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@NoArgsConstructor
public class S3Service implements ApplicationListener<ApplicationStartedEvent> {
    private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.address}")
    public String CLOUD_FRONT_DOMAIN_NAME;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

    public String upload(MultipartFile file) throws IOException {
        String fileName ="";
        if(file!= null) {
            String contentType = file.getContentType();

            // 확장자가 jpeg, jpg, gif, png가 아니면 업로드 실패
            if (!(contentType.contains("image/jpeg") || contentType.contains("image/jpg") || contentType.contains("image/png") || contentType.contains("image/gif"))) {
                throw new IllegalArgumentException("이미지 확장자가 올바르지 않습니다.");
            }
            // 고유한 key 값을 갖기위해 현재 시간을 postfix로 붙여줌
            SimpleDateFormat date = new SimpleDateFormat("yyyymmddHHmmss");
            fileName += file.getOriginalFilename() + "-" + date.format(new Date());
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            // 파일 업로드
            s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        }
        return fileName;
    }

    public void delete(final String fileName) {
        final String decodedFileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);
        s3Client.deleteObject(bucket, decodedFileName);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        
    }
}