package com.printingservice.services;

import com.printingservice.dtos.productmaterial.request.UpdateProductMaterialRQ;
import com.printingservice.models.ProductMaterial;
import com.printingservice.repositories.ProductMaterialRepository;
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
    return productMaterialRepository.findById(id).orElse(null);
  }

  public List<ProductMaterial> findAll() {
    return productMaterialRepository.findAll();
  }

  public ProductMaterial updateById(Long id, UpdateProductMaterialRQ updateProductMaterialRQ) {
    return productMaterialRepository
        .findById(id)
        .map(
            productMaterial -> {
              modelMapper.getConfiguration().setSkipNullEnabled(true);
              modelMapper.map(updateProductMaterialRQ, productMaterial);
              return productMaterialRepository.save(productMaterial);
            })
        .orElse(null);
  }

  public void deleteById(Long id) {
    productMaterialRepository.deleteById(id);
  }
}
