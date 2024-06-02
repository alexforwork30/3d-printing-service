package com.printingservice.services;

import com.printingservice.dtos.common.productrequest.ProductRequestDto;
import com.printingservice.dtos.productrequest.request.ModifyProductRequestReq;
import com.printingservice.enums.product.EProductRequestStatus;
import com.printingservice.models.ProductRequest;
import com.printingservice.models.User;
import com.printingservice.repositories.ProductRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductRequestService {
  private final ProductRequestRepository productRequestRepository;
  private final ModelMapper modelMapper;

  public ProductRequestDto create(Long userId, ModifyProductRequestReq modifyProductRequestReq) {
    ProductRequest productRequest = modelMapper.map(modifyProductRequestReq, ProductRequest.class);
    productRequest.setCustomer(User.builder().id(userId).build());
    productRequest.setProduct(null);
    ProductRequest savedProductRequest = productRequestRepository.save(productRequest);
    return modelMapper.map(savedProductRequest, ProductRequestDto.class);
  }

  public Page<ProductRequestDto> findAllByCustomerId(
      Long userId, EProductRequestStatus status, Integer page, Integer size) {
    ProductRequest probe = new ProductRequest();
    probe.setStatus(status);
    probe.setCustomer(User.builder().id(userId).build());
    Example<ProductRequest> example = Example.of(probe);
    Pageable pageable = PageRequest.of(page, size);
    Page<ProductRequest> productRequests = productRequestRepository.findAll(example, pageable);
    return productRequests.map(
        productRequest -> modelMapper.map(productRequest, ProductRequestDto.class));
  }

  public List<ProductRequest> findAll() {
    return productRequestRepository.findAll();
  }

  public ProductRequestDto findByIdAndCustomerId(Long id, Long customerId) {
    ProductRequest productRequest =
        productRequestRepository
            .findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new EntityNotFoundException("Product request not found"));
    return modelMapper.map(productRequest, ProductRequestDto.class);
  }

  public ProductRequest findById(Long id) {
    return productRequestRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product request not found"));
  }

  public ProductRequestDto updateByIdAndCustomerId(
      Long id, Long customerId, ModifyProductRequestReq modifyProductRequestReq) {
    ProductRequest productRequest =
        productRequestRepository
            .findByIdAndCustomerId(id, customerId)
            .orElseThrow(() -> new EntityNotFoundException("Product request not found"));
    modelMapper.getConfiguration().setSkipNullEnabled(true);
    modelMapper.map(modifyProductRequestReq, productRequest);
    ProductRequest savedProductRequest = productRequestRepository.save(productRequest);
    return modelMapper.map(savedProductRequest, ProductRequestDto.class);
  }

  public void deleteByIdAndCustomerId(Long id, Long customerId) {
    productRequestRepository.deleteByIdAndCustomerId(id, customerId);
  }
}
