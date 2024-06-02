package com.printingservice.controllers.customer;

import com.printingservice.models.ProductCategory;
import com.printingservice.services.ProductCategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.customer}/product-categories")
@RequiredArgsConstructor
public class CustomerProductCategoryController {
  private final ProductCategoryService productCategoryService;

  @GetMapping
  public List<ProductCategory> findAll() {
    return productCategoryService.findAll();
  }

  @GetMapping("/{id}")
  public ProductCategory findById(Long id) {
    return productCategoryService.findById(id);
  }
}
