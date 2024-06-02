package com.printingservice.controllers.manager;

import com.printingservice.dtos.common.product.ProductDto;
import com.printingservice.dtos.product.request.ModifyProductReq;
import com.printingservice.models.Product;
import com.printingservice.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.manager}/products")
@RequiredArgsConstructor
public class ManagerProductController {
  private final ProductService productService;

  @PostMapping
  public Product create(
      @RequestParam("categoryId") Long productCategoryId,
      @RequestParam("materialId") Long productMaterialId,
      @Valid @RequestBody ModifyProductReq modifyProductReq) {
    return productService.create(productCategoryId, productMaterialId, modifyProductReq);
  }

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

  @PatchMapping("/{id}")
  public Product updateById(
      @PathVariable("id") Long id,
      @RequestParam("categoryId") Long productCategoryId,
      @RequestParam("materialId") Long productMaterialId,
      @Valid @RequestBody ModifyProductReq modifyProductReq) {
    return productService.updateById(id, productCategoryId, productMaterialId, modifyProductReq);
  }
}
