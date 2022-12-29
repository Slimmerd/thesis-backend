package ru.thesis.backend.entity.delivery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.courier.CourierUserEntity;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DeliveryReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float rate;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "courierUser_id")
    private CourierUserEntity courierUser;
    @OneToOne(mappedBy = "deliveryReview")
    private DeliveryEntity delivery;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
