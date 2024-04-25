package com.printingservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pings")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Ping extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;
}
