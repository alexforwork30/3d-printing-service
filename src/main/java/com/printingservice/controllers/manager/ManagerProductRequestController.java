package com.printingservice.controllers.manager;

import com.printingservice.models.ProductRequest;
import com.printingservice.services.ProductRequestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.api-prefix.manager}/product-requests")
@RequiredArgsConstructor
public class ManagerProductRequestController {
  private final ProductRequestService productRequestService;

  @GetMapping
  public List<ProductRequest> findAll() {
    return productRequestService.findAll();
  }

  @GetMapping("/{id}")
  public ProductRequest findById(Long id) {
    return productRequestService.findById(id);
  }
}
