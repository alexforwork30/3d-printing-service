package com.printingservice.dtos.productmaterial.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateProductMaterialRQ {
  private String name;
  private String strength;
  private String flexibility;
  private String temperatureResistance;
  private String durability;
}
