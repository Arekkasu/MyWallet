package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Revenue repository.
 */
@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {


    //LISTAR LOS INGRESOS
    List<Revenue> findAll();


    /**
     * Find by users username list.
     *
     * @param Username the username
     * @return the list
     */
//ENCONTRAR LOS INGRESOS POR USUARIO6
    List<Revenue> findByUsers_Username(String Username);


    /**
     * Delete by id revenue.
     *
     * @param id the id
     */
//ELIMINAR POR ID
    void deleteByIdRevenue(Long id);


    /**
     * Find by id revenue revenue.
     *
     * @param id the id
     * @return the revenue
     */
//ENCONTRAR POR ID
    Revenue findByIdRevenue(Long id);


    /**
     * Find top 10 by users username list.
     *
     * @param username the username
     * @return the list
     */
    List<Revenue> findTop10ByUsers_Username(String username);






}
