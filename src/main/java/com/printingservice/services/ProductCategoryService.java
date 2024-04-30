package com.printingservice.services;

import com.printingservice.dtos.productcategory.request.UpdateProductCategoryReq;
import com.printingservice.models.ProductCategory;
import com.printingservice.repositories.ProductCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
  private final ProductCategoryRepository productCategoryRepository;
  private final ModelMapper modelMapper;

  public ProductCategory create(ProductCategory productCategory) {
    return productCategoryRepository.save(productCategory);
  }

  public ProductCategory findById(Long id) {
    return productCategoryRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("ProductCategory not found"));
  }

  public List<ProductCategory> findAll() {
    return productCategoryRepository.findAll();
  }

  public ProductCategory updateById(Long id, UpdateProductCategoryReq updateProductCategoryReq) {
    return productCategoryRepository
        .findById(id)
        .map(
            productCategory -> {
              modelMapper.getConfiguration().setSkipNullEnabled(true);
              modelMapper.map(updateProductCategoryReq, productCategory);
              return productCategoryRepository.save(productCategory);
            })
        .orElseThrow(() -> new EntityNotFoundException("ProductCategory not found"));
  }

  public void deleteById(Long id) {
    productCategoryRepository.deleteById(id);
  }
}
