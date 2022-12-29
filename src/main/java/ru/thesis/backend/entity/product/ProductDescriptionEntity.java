package ru.thesis.backend.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductDescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer protein;
    private Integer carb;
    private Integer fat;

    private String ingredients;

    private String manufacturer;
    private String storageCond;
    private String shelfLife;
    private String brand;


    @OneToOne(mappedBy = "productDescription")
    private ProductEntity product;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
