package com.printingservice.services;

import com.printingservice.dtos.common.product.ProductDto;
import com.printingservice.dtos.common.product.ProductWithRelationsDto;
import com.printingservice.dtos.product.request.ModifyProductReq;
import com.printingservice.models.Product;
import com.printingservice.models.ProductCategory;
import com.printingservice.models.ProductMaterial;
import com.printingservice.repositories.ProductCategoryRepository;
import com.printingservice.repositories.ProductMaterialRepository;
import com.printingservice.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductMaterialRepository productMaterialRepository;
  private final ModelMapper modelMapper;

  public Product create(
      Long productCategoryId, Long productMaterialId, ModifyProductReq modifyProductReq) {
    ProductCategory productCategory =
        productCategoryRepository
            .findById(productCategoryId)
            .orElseThrow(() -> new EntityNotFoundException("Product category not found"));
    ProductMaterial productMaterial =
        productMaterialRepository
            .findById(productMaterialId)
            .orElseThrow(() -> new EntityNotFoundException("Product material not found"));
    Product product = modelMapper.map(modifyProductReq, Product.class);
    product.setProductCategory(productCategory);
    product.setProductMaterial(productMaterial);
    return productRepository.save(product);
  }

  public <T extends ProductDto> Page<T> findAll(
      Long productCategoryId, Integer page, Integer size, Boolean includeRelations) {
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> products = productRepository.findByProductCategoryId(productCategoryId, pageable);

    return products.map(
        product ->
            modelMapper.map(
                product, includeRelations ? ProductWithRelationsDto.class : ProductDto.class));
  }

  public <T extends ProductDto> T findById(Long id, Boolean includeRelations) {
    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    return modelMapper.map(
        product, includeRelations ? ProductWithRelationsDto.class : ProductDto.class);
  }

  public Product updateById(
      Long id, Long productCategoryId, Long productMaterialId, ModifyProductReq modifyProductReq) {
    ProductCategory productCategory =
        productCategoryRepository
            .findById(productCategoryId)
            .orElseThrow(() -> new EntityNotFoundException("Product category not found"));
    ProductMaterial productMaterial =
        productMaterialRepository
            .findById(productMaterialId)
            .orElseThrow(() -> new EntityNotFoundException("Product material not found"));
    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    modelMapper.getConfiguration().setSkipNullEnabled(true);
    modelMapper.map(modifyProductReq, product);
    product.setProductCategory(productCategory);
    product.setProductMaterial(productMaterial);

    return productRepository.save(product);
  }
}
