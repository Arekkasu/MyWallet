package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository  extends JpaRepository<Roles, Long> {

    boolean existsByRoleName(String roleName);

    Roles findByRoleName(String roleName);

}
