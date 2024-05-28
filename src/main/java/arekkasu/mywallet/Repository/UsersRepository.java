package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Users repository.
 */
@Repository
public interface UsersRepository  extends JpaRepository<Users, Long> {


    /**
     * Find by username users.
     *
     * @param username the username
     * @return the users
     */
//@Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findByUsername(String username);

    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    boolean existsByUsername(String username);

    /**
     * Find by id users users.
     *
     * @param username the username
     * @return the users
     */
    Users findByIdUsers(Long username);

    /**
     * Delete by id users.
     *
     * @param id the id
     */
    void deleteByIdUsers(Long id);


    /**
     * Find all by order by id users asc list.
     *
     * @return the list
     */
//OBTENER TODOS LOS USUARIOS ORDENADOS POR ID
    List<Users> findAllByOrderByIdUsersAsc();


    @Modifying
    @Query(value = "DELETE FROM users_roles WHERE id_users = :userId", nativeQuery = true)
    void deleteUserRoles(@Param("userId") Long userId);

}
