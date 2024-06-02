package com.printingservice.services;

import com.printingservice.dtos.productmaterial.request.UpdateProductMaterialReq;
import com.printingservice.models.ProductMaterial;
import com.printingservice.repositories.ProductMaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMaterialService {
  private final ProductMaterialRepository productMaterialRepository;
  private final ModelMapper modelMapper;

  public ProductMaterial create(ProductMaterial productMaterial) {
    return productMaterialRepository.save(productMaterial);
  }

  public ProductMaterial findById(Long id) {
    return productMaterialRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("ProductMaterial not found"));
  }

  public List<ProductMaterial> findAll() {
    return productMaterialRepository.findAll();
  }

  public ProductMaterial updateById(Long id, UpdateProductMaterialReq updateProductMaterialReq) {
    return productMaterialRepository
        .findById(id)
        .map(
            productMaterial -> {
              modelMapper.getConfiguration().setSkipNullEnabled(true);
              modelMapper.map(updateProductMaterialReq, productMaterial);
              return productMaterialRepository.save(productMaterial);
            })
        .orElseThrow(() -> new EntityNotFoundException("ProductMaterial not found"));
  }

  public void deleteById(Long id) {
    productMaterialRepository.deleteById(id);
  }
}
