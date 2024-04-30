package com.printingservice.dtos.common.productmaterial;

import com.printingservice.dtos.common.BaseEntityDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductMaterialDto extends BaseEntityDto {
  private Long id;
  private String name;
  private String strength;
  private String flexibility;
  private String temperatureResistance;
  private String durability;
}
