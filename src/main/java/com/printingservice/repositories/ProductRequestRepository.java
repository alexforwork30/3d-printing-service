package com.printingservice.repositories;

import com.printingservice.models.ProductRequest;
import java.util.Optional;

public interface ProductRequestRepository extends BaseRepository<ProductRequest, Long> {
  Optional<ProductRequest> findByIdAndCustomerId(Long id, Long customerId);

  void deleteByIdAndCustomerId(Long id, Long customerId);
}
