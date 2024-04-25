package com.printingservice.models;

import com.printingservice.enums.order.EOrderPaymentMethod;
import com.printingservice.enums.order.EOrderPaymentStatus;
import com.printingservice.enums.order.EOrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Order extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EOrderPaymentStatus paymentStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EOrderPaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private User user;

    @PrePersist
    public void prePersist() {
        if (this.orderStatus == null) {
            this.orderStatus = EOrderStatus.PENDING;
        }
        if (this.paymentStatus == null) {
            this.paymentStatus = EOrderPaymentStatus.PENDING;
        }
    }
}
