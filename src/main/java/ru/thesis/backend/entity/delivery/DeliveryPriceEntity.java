package ru.thesis.backend.entity.delivery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.warehouse.WarehouseEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DeliveryPriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minimumOrderPrice;
    private Integer servicePrice;
    private Integer demandCharge = 0;


    @OneToOne(mappedBy = "deliveryPrice")
    private WarehouseEntity warehouse;
    @OneToMany(mappedBy = "deliveryPrice")
    private List<DeliveryPriceOptionsEntity> deliveryPriceOptions;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
