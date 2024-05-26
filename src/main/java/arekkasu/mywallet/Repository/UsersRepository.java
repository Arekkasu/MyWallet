package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Long> {


    //@Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findByUsername(String username);

    boolean existsByUsername(String username);

    Users findByIdUsers(Long username);

    void deleteByIdUsers(Long id);


    //OBTENER TODOS LOS USUARIOS ORDENADOS POR ID
    List<Users> findAllByOrderByIdUsersAsc();

}
