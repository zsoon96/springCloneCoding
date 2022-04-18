//package com.sparta.springclonecoding.service;
//
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Optional;
//import java.util.UUID;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class S3Uploader {
//
//    private final AmazonS3Client amazonS3Client;
//
//    @Value("${cloud.aws.s3.bucket}")
//    public String bucket;  // S3 버킷 이름
//
//    // S3에 사용되려는 파일로 변환
//    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
////        System.out.println(multipartFile);
////        System.out.println(dirName);
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException("error: MultipartFile -> File convert fail"));
//        return upload(uploadFile, dirName);
//    }
//
//    // 이미지 파일 수정
//    public String uploadRe(String currentFilePath, MultipartFile multipartFile) throws IOException {
//        File uploadFile = convert(multipartFile)  // 파일 변환할 수 없으면 에러
//                .orElseThrow(() -> new IllegalArgumentException("error: MultipartFile -> File convert fail"));
//
//        // key가 존재하면 기존 파일은 삭제
//        if ("".equals(currentFilePath) == false && currentFilePath != null) { // 경로에 값이 들어있다면
//            boolean isExistObject = amazonS3Client.doesObjectExist(bucket, currentFilePath); // 수정하려는 파일과 동일한 파일이 있는지 체크
//
//            if (isExistObject == true) { // 동일한 파일이 있다면
//                amazonS3Client.deleteObject(bucket, currentFilePath); // 현재 경로에 있는 해당 파일을 삭제
//            }log.info("기존 파일 삭제 성공");
//        }
//        return upload(uploadFile, currentFilePath);
//    }
//
//    // S3에 파일 업로드하기
//    private String upload(File uploadFile, String dirName) {
//        String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.getName();   // S3에 저장된 파일 이름
//        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
//        removeNewFile(uploadFile); // 로컬에 저장되있는 파일 지우기
//        return uploadImageUrl;
//    }
//
//    // S3 파일 업로드 상세 메소드
//    private String putS3(File uploadFile, String fileName) {
//        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
//        return amazonS3Client.getUrl(bucket, fileName).toString(); // 서비스에게 건네지는 최종 반환 값 = url
//    }
//
//    // 로컬에 저장된 이미지 지우기
//    private void removeNewFile(File targetFile) {
//        if (targetFile.delete()) {
//            log.info("File delete success");
//            return;
//        }
//        log.info("File delete fail");
//    }
//
//    // 로컬에 새 파일 생성 후 파일 업로드 하기
//    private Optional<File> convert(MultipartFile file) throws IOException {
//        File convertFile = new File(System.getProperty("user.dir") + "/" + file.getOriginalFilename());
//        if (convertFile.createNewFile()) { // 바로 위에서 지정한 경로에 File이 생성됨 (경로가 잘못되었다면 생성 불가능)
//            try (FileOutputStream fos = new FileOutputStream(convertFile)) { // FileOutputStream 데이터를 파일에 바이트 스트림으로 저장하기 위함
//                fos.write(file.getBytes());
//            }
//            return Optional.of(convertFile);
//        }
//
//        return Optional.empty();
//    }
//
//}