package com.printingservice.dtos.common.productrequest;

import com.printingservice.dtos.common.product.ProductDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProductRequestWithRelationsDto extends ProductRequestDto {
  private ProductDto product;
}
