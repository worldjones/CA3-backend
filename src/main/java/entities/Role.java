package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Plaul
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    public static final Roles DEFAULT_ROLE = Roles.USER;

    public enum Roles {
        USER,
        ADMIN
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_name", length = 20)
    private Roles roleName;
    
    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    public Role() {
    }

    public Role(Roles role) {
        this.roleName = role;
    }

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles role) {
        this.roleName = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }   
}
