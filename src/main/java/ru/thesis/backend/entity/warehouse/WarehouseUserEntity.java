package ru.thesis.backend.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.thesis.backend.entity.order.OrderEntity;
import ru.thesis.backend.entity.enums.WarehouseUserRole;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WarehouseUserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String firstName;

    private String lastName;

    private String documentsStoredUrl;

    private Boolean isBlocked = false;

    private Boolean isActivated = false;

    @Enumerated(EnumType.STRING)
    private WarehouseUserRole warehouseUserRole = WarehouseUserRole.Assistant;

    @OneToMany(mappedBy = "warehouseUser", cascade = CascadeType.ALL)
    private List<WarehouseUserCodeEntity> warehouseUserCodes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseUser")
    private List<WarehouseUserNotificationTokenEntity> warehouseUserNotificationTokens;

    @OneToMany(mappedBy = "warehouseUser", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<OrderEntity> orders;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime updatedAt;


    // Code
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(warehouseUserRole.name());

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
