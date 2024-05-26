package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * The interface Roles repository.
 */
@Repository
public interface RolesRepository  extends JpaRepository<Roles, Long> {

    /**
     * Exists by role name boolean.
     *
     * @param roleName the role name
     * @return the boolean
     */
    boolean existsByRoleName(String roleName);

    /**
     * Find by role name roles.
     *
     * @param roleName the role name
     * @return the roles
     */
    Roles findByRoleName(String roleName);

}
