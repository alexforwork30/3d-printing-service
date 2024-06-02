package com.printingservice.dtos.common.productcategory;

import com.printingservice.dtos.common.BaseEntityDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCategoryDto extends BaseEntityDto {
  private Long id;
  private String name;
  private String description;
}
