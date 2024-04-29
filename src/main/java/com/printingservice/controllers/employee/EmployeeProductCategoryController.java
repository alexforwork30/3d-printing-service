package com.printingservice.controllers.employee;

import com.printingservice.models.ProductCategory;
import com.printingservice.services.ProductCategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.employee}/product-categories")
@RequiredArgsConstructor
public class EmployeeProductCategoryController {
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
