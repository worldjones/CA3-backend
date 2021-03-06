package entities;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Plaul
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    // Default final utility.
    public static final String DEFAULT_ROLE = "user";
    public static final List<String> SYSTEM_ROLES = ImmutableList.of("user", "admin");
    public static String findRole(String role) {
        return SYSTEM_ROLES.stream().filter(r -> r.equalsIgnoreCase(role)).findAny().orElse(null);
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(length = 20)
    private String name;
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(String role) {
        this.name = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> userList) {
        this.users = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
