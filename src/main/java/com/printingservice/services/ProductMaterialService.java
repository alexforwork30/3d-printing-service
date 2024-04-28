package com.printingservice.services;

import com.printingservice.repositories.ProductMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMaterialService {
    private final ProductMaterialRepository productMaterialRepository;
}
