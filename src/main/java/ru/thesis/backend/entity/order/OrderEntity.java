package ru.thesis.backend.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.delivery.DeliveryAddressEntity;
import ru.thesis.backend.entity.delivery.DeliveryEntity;
import ru.thesis.backend.entity.user.UserEntity;
import ru.thesis.backend.entity.warehouse.WarehouseEntity;
import ru.thesis.backend.entity.warehouse.WarehouseUserEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer subTotal;
    private Integer servicePrice;
    private Integer deliveryPrice;
    private Integer total;
    private Integer waitingTime;
    private String comment;
    private String promoCode;
    private Integer promoDiscount;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private DeliveryAddressEntity deliveryAddress;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<DeliveryEntity> delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntities;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLogEntity> orderLog;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<OrderPaymentEntity> orderPayment;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private OrderReviewEntity orderReview;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "warehouseUser_id")
    private WarehouseUserEntity warehouseUser;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;


}
