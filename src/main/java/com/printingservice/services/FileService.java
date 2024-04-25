package com.printingservice.services;

import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.StorageClient;
import com.printingservice.constants.FirebaseConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FirebaseApp firebaseApp;

    public String uploadFile(MultipartFile multipartFile, String folderPath) throws IOException {
        Bucket bucket = StorageClient.getInstance(firebaseApp).bucket();
        String fileName = UUID.randomUUID().toString();
        String filePath = folderPath + '/' + fileName;
        bucket.create(filePath, multipartFile.getBytes(), multipartFile.getContentType());
        return String.format(FirebaseConstants.DOWNLOAD_URL, bucket.getName(), URLEncoder.encode(filePath, StandardCharsets.UTF_8));
    }
}
