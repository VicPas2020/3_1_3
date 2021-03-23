package ru.vicpas.spjs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "roletable")

public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @JsonIgnore // потому что это поле не должно сериализоваться, но должно быть в базе
//    @Transient
    @ManyToMany(mappedBy = "userRoles", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();


    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role(Long id, String role, Set<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return role;
    }


    @Override
    public String toString() {
        return role;
    }

}
