package com.printingservice.dtos.productcategory.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProductCategoryReq {
  private String name;
  private String description;
}
