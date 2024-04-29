package com.printingservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_materials")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProductMaterial extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(length = 100)
  private String strength;

  @Column(length = 100)
  private String flexibility;

  @Column(length = 100)
  private String temperatureResistance;

  @Column(length = 100)
  private String durability;
}
