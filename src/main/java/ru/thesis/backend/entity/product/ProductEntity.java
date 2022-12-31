package ru.thesis.backend.entity.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.category.SubcategoryEntity;
import ru.thesis.backend.entity.enums.Vat;
import ru.thesis.backend.entity.enums.VolumeType;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isHidden;

    private String promDescription;

    private Integer price;

    private Integer volume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductStockEntity> productStock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productDesc_id")
    private ProductDescriptionEntity productDescription;

    @ManyToMany(mappedBy = "product")
    private List<SubcategoryEntity> subcategories;

    @Enumerated(EnumType.STRING)
    private VolumeType volumeType;

    @Enumerated(EnumType.STRING)
    private Vat vat;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
