package com.printingservice.repositories;

import com.printingservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends BaseRepository<Product, Long> {
  Page<Product> findByProductCategoryId(Long productCategoryId, Pageable pageable);
}
