package ru.thesis.backend.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.thesis.backend.entity.enums.Vat;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WarehouseLegalDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String legalCompanyName;
    private String legalAddress;

    private String inn;
    private String kpp;
    private String ogrn;
    private String documentsStoredUrl;
    private String signerName;
    private String signerPosition;
    private String accounting_email;
    private Long bankId;
    private String checkoutAccount;

    @Enumerated(EnumType.STRING)
    private Vat vat = Vat.none;

    @OneToOne(mappedBy = "warehouseLegalData")
    private WarehouseEntity warehouse;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;
}
