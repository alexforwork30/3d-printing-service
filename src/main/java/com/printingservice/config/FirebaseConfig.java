package com.printingservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor
public class FirebaseConfig {
  @Value("${printingservice.firebase.bucket-name}")
  private String bucketName;

  @Bean
  public FirebaseApp initializeFirebase() throws IOException {
    ClassPathResource resource = new ClassPathResource("firebase-credentials.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
    FirebaseOptions options =
        FirebaseOptions.builder().setCredentials(credentials).setStorageBucket(bucketName).build();
    return FirebaseApp.initializeApp(options);
  }
}
