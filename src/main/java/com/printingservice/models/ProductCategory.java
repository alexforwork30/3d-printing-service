package com.printingservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_categories")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProductCategory extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private String description;
}
