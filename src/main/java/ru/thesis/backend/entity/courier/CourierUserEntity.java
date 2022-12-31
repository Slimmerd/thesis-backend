package ru.thesis.backend.entity.courier;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.thesis.backend.entity.delivery.DeliveryEntity;
import ru.thesis.backend.entity.delivery.DeliveryReviewEntity;
import ru.thesis.backend.entity.enums.CourierStatus;
import ru.thesis.backend.entity.enums.CourierUserRole;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CourierUserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String firstName;
    private String lastName;
    private Long balance;
    private Float rating;
    private String documentsStoredUrl;
    private Boolean isBlocked = false;
    private String comment;
    private Boolean isActivated = false;
    private Double lng;
    private Double lat;


    @OneToMany(mappedBy = "courierUser", cascade = CascadeType.ALL)
    private List<CourierUserNotificationTokenEntity> courierUserNotificationTokens;

    @ManyToOne
    @JoinColumn(name = "courierPark_id")
    private CourierParkEntity courierPark;

    @OneToMany(mappedBy = "courierUser", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<DeliveryEntity> deliveries;

    @Enumerated(EnumType.STRING)
    private CourierStatus courierStatus = CourierStatus.Offline;

    @Enumerated(EnumType.STRING)
    private CourierUserRole courierUserRole = CourierUserRole.Courier;

    @OneToMany(mappedBy = "courierUser", cascade = CascadeType.ALL)
    private List<DeliveryReviewEntity> deliveryReviews;

    @OneToMany(mappedBy = "courierUser", cascade = CascadeType.ALL)
    private List<CourierUserCodeEntity> courierUserCodes;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;

// Code

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(courierUserRole.name());

        return Collections.singletonList(authority);

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isBlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActivated;
    }

}
