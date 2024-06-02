package com.printingservice.models;

import com.printingservice.enums.product.EProductStatus;
import com.printingservice.enums.product.EProductType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Product extends Base {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column private String description;

  @Column private String thumbnailUrl;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Integer printingTime;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EProductType productType;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EProductStatus status;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_request_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private ProductRequest productRequest;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_category_id", nullable = false)
  @OnDelete(action = OnDeleteAction.RESTRICT)
  private ProductCategory productCategory;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_material_id", nullable = false)
  @OnDelete(action = OnDeleteAction.RESTRICT)
  private ProductMaterial productMaterial;

  @PrePersist
  public void prePersist() {
    if (productType == null) {
      productType = EProductType.PRE_DESIGNED;
    }
    if (status == null) {
      status = EProductStatus.AVAILABLE;
    }
  }
}
