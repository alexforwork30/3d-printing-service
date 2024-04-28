package com.printingservice.services;

import com.printingservice.repositories.ProductRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductRequestService {
    private final ProductRequestRepository productRequestRepository;
}
