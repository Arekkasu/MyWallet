package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {


    //LISTAR LOS INGRESOS
    List<Revenue> findAll();


    //ENCONTRAR LOS INGRESOS POR USUARIO6
    List<Revenue> findByUsers_Username(String Username);



    //ELIMINAR POR ID
    void deleteByIdRevenue(Long id);


    //ENCONTRAR POR ID
    Revenue findByIdRevenue(Long id);


    List<Revenue> findTop10ByUsers_Username(String username);






}
