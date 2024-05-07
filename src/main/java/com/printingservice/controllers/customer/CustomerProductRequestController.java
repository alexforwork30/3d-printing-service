package com.printingservice.controllers.customer;

import com.printingservice.dtos.common.productrequest.ProductRequestDto;
import com.printingservice.dtos.productrequest.request.ModifyProductRequestReq;
import com.printingservice.enums.product.EProductRequestStatus;
import com.printingservice.models.UserCredential;
import com.printingservice.services.ProductRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.api-prefix.customer}/product-requests")
@RequiredArgsConstructor
public class CustomerProductRequestController {
  private final ProductRequestService productRequestService;

  @PostMapping
  public ProductRequestDto create(
      @AuthenticationPrincipal UserCredential userCredential,
      @Valid @RequestBody ModifyProductRequestReq modifyProductRequestReq) {
    Long userId = userCredential.getId();
    return productRequestService.create(userId, modifyProductRequestReq);
  }

  @GetMapping
  public Page<ProductRequestDto> findAll(
      @AuthenticationPrincipal UserCredential userCredential,
      @RequestParam("status") EProductRequestStatus status,
      @RequestParam("page") Integer page,
      @RequestParam("size") Integer size) {
    Long userId = userCredential.getId();
    return productRequestService.findAllByCustomerId(userId, status, page, size);
  }

  @GetMapping("/{id}")
  public ProductRequestDto findById(
      @AuthenticationPrincipal UserCredential userCredential, @PathVariable("id") Long id) {
    Long userId = userCredential.getId();
    return productRequestService.findByIdAndCustomerId(id, userId);
  }

  @PatchMapping("/{id}")
  public ProductRequestDto updateById(
      @AuthenticationPrincipal UserCredential userCredential,
      @PathVariable("id") Long id,
      @Valid @RequestBody ModifyProductRequestReq modifyProductRequestReq) {
    Long userId = userCredential.getId();
    return productRequestService.updateByIdAndCustomerId(id, userId, modifyProductRequestReq);
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @AuthenticationPrincipal UserCredential userCredential, @PathVariable("id") Long id) {
    Long userId = userCredential.getId();
    productRequestService.deleteByIdAndCustomerId(id, userId);
  }
}
