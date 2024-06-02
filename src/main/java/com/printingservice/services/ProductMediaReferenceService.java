package com.printingservice.services;

import com.printingservice.repositories.ProductMediaReferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMediaReferenceService {
  private final ProductMediaReferenceRepository productMediaReferenceRepository;
}
