package com.printingservice.controllers.manager;

import com.printingservice.dtos.productcategory.request.UpdateProductCategoryRQ;
import com.printingservice.models.ProductCategory;
import com.printingservice.services.ProductCategoryService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.manager}/product-categories")
@RequiredArgsConstructor
public class ManagerProductCategoryController {
  private final ProductCategoryService productCategoryService;

  @PostMapping
  public ProductCategory create(@Valid @RequestBody ProductCategory productCategory) {
    return productCategoryService.create(productCategory);
  }

  @GetMapping
  public List<ProductCategory> findAll() {
    return productCategoryService.findAll();
  }

  @GetMapping("/{id}")
  public ProductCategory findById(@PathVariable("id") Long id) {
    return productCategoryService.findById(id);
  }

  @PatchMapping("/{id}")
  public ProductCategory updateById(
      @PathVariable("id") Long id,
      @Valid @RequestBody UpdateProductCategoryRQ updateProductCategoryRQ) {
    return productCategoryService.updateById(id, updateProductCategoryRQ);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    productCategoryService.deleteById(id);
  }
}
