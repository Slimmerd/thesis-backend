package ru.thesis.backend.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.delivery.DeliveryPriceEntity;
import ru.thesis.backend.entity.order.OrderEntity;
import ru.thesis.backend.entity.product.ProductStockEntity;
import ru.thesis.backend.model.WarehouseStatus;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    @Enumerated(EnumType.STRING)
    private WarehouseStatus warehouseStatus = WarehouseStatus.Offline;

    private Integer deliveryTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicePrice_id")
    private DeliveryPriceEntity deliveryPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouseTimetable_id")
    private WarehouseTimetableEntity warehouseTimetable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private WarehouseAddressEntity address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouseLegalData_id")
    private WarehouseLegalDataEntity legalData;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<ProductStockEntity> productStock;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;

}
