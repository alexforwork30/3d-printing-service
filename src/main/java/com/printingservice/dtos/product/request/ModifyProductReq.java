package com.printingservice.dtos.product.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModifyProductReq {
  private String name;
  private String description;
  private String thumbnailUrl;
  private Double price;
  private Integer printingTime;
}
