package com.printingservice.dtos.common.product;

import com.printingservice.dtos.common.BaseEntityDto;
import com.printingservice.enums.product.EProductStatus;
import com.printingservice.enums.product.EProductType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends BaseEntityDto {
  private Long id;
  private String name;
  private String description;
  private String thumbnailUrl;
  private Double price;
  private Integer printingTime;
  private EProductType productType;
  private EProductStatus status;

  private Long productRequestId;
  private Long productCategoryId;
  private Long productMaterialId;
}
