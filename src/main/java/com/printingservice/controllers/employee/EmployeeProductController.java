package com.printingservice.controllers.employee;

import com.printingservice.dtos.common.product.ProductDto;
import com.printingservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.employee}/products")
@RequiredArgsConstructor
public class EmployeeProductController {
  private final ProductService productService;

  @GetMapping("/{id}")
  public <T extends ProductDto> T findById(
      @PathVariable("id") Long id,
      @RequestParam(value = "includeRelations", defaultValue = "false") Boolean includeRelations) {
    return productService.findById(id, includeRelations);
  }

  @GetMapping
  public Page<ProductDto> findAll(
      @RequestParam("categoryId") Long productCategoryId,
      @RequestParam("page") Integer page,
      @RequestParam("size") Integer size,
      @RequestParam(value = "includeRelations", defaultValue = "false") Boolean includeRelations) {
    return productService.findAll(productCategoryId, page, size, includeRelations);
  }
}
