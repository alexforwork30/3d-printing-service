package com.printingservice.models;

import com.printingservice.enums.product.EProductRequestStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product_requests")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProductRequest extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String fileUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EProductRequestStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private User user;

    @OneToOne(mappedBy = "productRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Product product;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = EProductRequestStatus.PENDING;
        }
    }
}
