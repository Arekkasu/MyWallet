package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Expenses repository.
 */
@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    //LISTAR TODOS

    /**
     * Find all by list.
     *
     * @return the list
     */
    List<Expenses> findAllBy();


    /**
     * Find by users id users list.
     *
     * @param id the id
     * @return the list
     */
// BUSCAR POR NOMBRE DE USUARIO
    List<Expenses> findByUsers_IdUsers(Long id);


    /**
     * Find by id expenses expenses.
     *
     * @param id the id
     * @return the expenses
     */
    Expenses findByIdExpenses(Long id);



    // BORRAR POR ID

    /**
     * Delete by id expenses.
     *
     * @param id the id
     */
    void deleteByIdExpenses(Long id);


    /**
     * Find top 10 by users username list.
     *
     * @param username the username
     * @return the list
     */
    List<Expenses> findTop10ByUsers_Username(String username);



}
