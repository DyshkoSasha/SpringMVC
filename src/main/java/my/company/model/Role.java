package my.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String getAuthority() {
        return role;
    }

    public Role(String role) {
        this.role = role;
    }
}
