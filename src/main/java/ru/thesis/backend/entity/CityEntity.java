package ru.thesis.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.thesis.backend.entity.warehouse.WarehouseAddressEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "city")
    private WarehouseAddressEntity address;


}
