package com.workintech.s19d2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="member",schema="fsweb")
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="member_role",schema="fsweb",joinColumns = @JoinColumn(name="member_id")
            ,inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> authorities = new HashSet<>();

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
