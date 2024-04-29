package com.printingservice.services;

import com.printingservice.repositories.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
  private final ProductCategoryRepository productCategoryRepository;
}
