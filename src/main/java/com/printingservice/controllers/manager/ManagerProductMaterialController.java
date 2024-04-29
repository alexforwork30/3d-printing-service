package com.printingservice.controllers.manager;

import com.printingservice.dtos.productmaterial.request.UpdateProductMaterialRQ;
import com.printingservice.models.ProductMaterial;
import com.printingservice.services.ProductMaterialService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.manager}/product-materials")
@RequiredArgsConstructor
public class ManagerProductMaterialController {
  private final ProductMaterialService productMaterialService;

  @PostMapping
  public ProductMaterial create(@Valid @RequestBody ProductMaterial productMaterial) {
    return productMaterialService.create(productMaterial);
  }

  @GetMapping
  public List<ProductMaterial> findAll() {
    return productMaterialService.findAll();
  }

  @GetMapping("/{id}")
  public ProductMaterial findById(@PathVariable("id") Long id) {
    return productMaterialService.findById(id);
  }

  @PatchMapping("/{id}")
  public ProductMaterial updateById(
      @PathVariable("id") Long id,
      @Valid @RequestBody UpdateProductMaterialRQ updateProductMaterialRQ) {
    return productMaterialService.updateById(id, updateProductMaterialRQ);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    productMaterialService.deleteById(id);
  }
}
