package com.printingservice.controllers.customer;

import com.printingservice.models.ProductMaterial;
import com.printingservice.services.ProductMaterialService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.customer}/product-materials")
@RequiredArgsConstructor
public class CustomerProductMaterialController {
  private final ProductMaterialService productMaterialService;

  @GetMapping
  public List<ProductMaterial> findAll() {
    return productMaterialService.findAll();
  }

  @GetMapping("/{id}")
  public ProductMaterial findById(@PathVariable("id") Long id) {
    return productMaterialService.findById(id);
  }
}
