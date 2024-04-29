package com.printingservice.services;

import com.printingservice.dtos.productcategory.request.UpdateProductCategoryRQ;
import com.printingservice.models.ProductCategory;
import com.printingservice.repositories.ProductCategoryRepository;
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
    return productCategoryRepository.findById(id).orElse(null);
  }

  public List<ProductCategory> findAll() {
    return productCategoryRepository.findAll();
  }

  public ProductCategory updateById(Long id, UpdateProductCategoryRQ updateProductCategoryRQ) {
    return productCategoryRepository
        .findById(id)
        .map(
            productCategory -> {
              modelMapper.getConfiguration().setSkipNullEnabled(true);
              modelMapper.map(updateProductCategoryRQ, productCategory);
              return productCategoryRepository.save(productCategory);
            })
        .orElse(null);
  }

  public void deleteById(Long id) {
    productCategoryRepository.deleteById(id);
  }
}
