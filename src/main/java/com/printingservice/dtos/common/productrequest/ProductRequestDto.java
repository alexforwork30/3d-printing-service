package com.printingservice.dtos.common.productrequest;

import com.printingservice.dtos.common.BaseEntityDto;
import com.printingservice.dtos.common.product.ProductDto;
import com.printingservice.enums.product.EProductRequestStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductRequestDto extends BaseEntityDto {
  private Long id;
  private String description;
  private String fileUrl;
  private EProductRequestStatus status;
}
