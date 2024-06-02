package com.printingservice.dtos.common.product;

import com.printingservice.dtos.common.productcategory.ProductCategoryDto;
import com.printingservice.dtos.common.productmaterial.ProductMaterialDto;
import com.printingservice.dtos.common.productrequest.ProductRequestDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProductWithRelationsDto extends ProductDto {
  private ProductRequestDto productRequest;
  private ProductCategoryDto productCategory;
  private ProductMaterialDto productMaterial;
}
