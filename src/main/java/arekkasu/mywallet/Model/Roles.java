package arekkasu.mywallet.Model;


import jakarta.persistence.*;


/**
 * The type Roles.
 */
@Entity
@Table(name = "roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String roleName;

    /**
     * Instantiates a new Roles.
     */
    public Roles() {
    }

    /**
     * Instantiates a new Roles.
     *
     * @param idRole   the id role
     * @param roleName the role name
     */
    public Roles(Long idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    /**
     * Instantiates a new Roles.
     *
     * @param roleName the role name
     */
    public Roles(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets id role.
     *
     * @return the id role
     */
    public Long getIdRole() {
        return idRole;
    }

    /**
     * Sets id role.
     *
     * @param idRole the id role
     */
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
