package ru.thesis.backend.entity.courier;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CourierParkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cityId;
    private String companyName;
    private String legalAddress;
    private Long balance;
    private Long percent;
    private String inn;
    private String kpp;
    private String ogrn;
    private Boolean isBlocked = false;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "courierPark")
    private List<CourierParkPaymentEntity> parkPayments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courierPark")
    private List<CourierUserEntity> couriers;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
