package com.printingservice.dtos.productcategory.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProductCategoryRQ {
  private String name;
  private String description;
}
