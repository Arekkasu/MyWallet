package arekkasu.mywallet.Repository;


import arekkasu.mywallet.Model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    //LISTAR TODOS





}