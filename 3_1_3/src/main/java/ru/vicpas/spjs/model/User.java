package ru.vicpas.spjs.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Getter
@Setter
@Entity(name = "usertable")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "level")
    private int level;


    @ManyToMany(/*cascade = CascadeType.MERGE,*/ fetch = FetchType.EAGER)
    @JoinTable(name = "usertable_roletable",
            joinColumns = {@JoinColumn(name = "usertable_id")},
            inverseJoinColumns = {@JoinColumn(name = "roletable_id")}
    )
    private Set<Role> userRoles;


    public User() {
    }

    // для ручного создания минимального админа.
    public User(String login, String password, String firstName, String lastName, int level, Set<Role> userRoles) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.userRoles = userRoles;
    }


    public User(Dto dto) {
        this.id         = dto.getId();
        this.login      = dto.getLogin();
        this.password   = dto.getPassword();
        this.firstName  = dto.getFirstName();
        this.lastName   = dto.getLastName();
        this.level      = dto.getLevel();
        this.userRoles = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles;
    }

    @Override
    public String getUsername() {
        return login;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", userRoles=" + userRoles +
                '}';
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public String getRolesStr() {
        StringBuilder sb = new StringBuilder();

        for (Role role : getUserRoles()) {
            sb.append(role.getRole());
            sb.append(" ");
        }
        return sb.toString();
    }

}
