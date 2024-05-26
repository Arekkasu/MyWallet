package arekkasu.mywallet.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * The type Expenses.
 */
@Entity
@Table(name = "Expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpenses;
    private String expenseHeader;

    private String expenseDescription;

    private LocalDate expenseDate;

    private int expenseAmount;

    @ManyToOne
    @JoinColumn(name = "Users_IdUsers")
    @JsonManagedReference
    private Users users;

    /**
     * Instantiates a new Expenses.
     */
    public Expenses() {
    }


    /**
     * Instantiates a new Expenses.
     *
     * @param idExpenses         the id expenses
     * @param expenseHeader      the expense header
     * @param expenseDescription the expense description
     * @param expenseDate        the expense date
     * @param expenseAmount      the expense amount
     * @param users              the users
     */
    public Expenses(Long idExpenses, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, Users users) {
        this.idExpenses = idExpenses;
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.users = users;
    }

    /**
     * Instantiates a new Expenses.
     *
     * @param expenseHeader      the expense header
     * @param expenseDescription the expense description
     * @param expenseDate        the expense date
     * @param expenseAmount      the expense amount
     * @param users              the users
     */
    public Expenses(String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, Users users) {
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.users = users;
    }

    /**
     * Gets id expenses.
     *
     * @return the id expenses
     */
    public Long getIdExpenses() {
        return idExpenses;
    }

    /**
     * Sets id expenses.
     *
     * @param idExpenses the id expenses
     */
    public void setIdExpenses(Long idExpenses) {
        this.idExpenses = idExpenses;
    }

    /**
     * Gets expense header.
     *
     * @return the expense header
     */
    public String getExpenseHeader() {
        return expenseHeader;
    }

    /**
     * Sets expense header.
     *
     * @param expenseHeader the expense header
     */
    public void setExpenseHeader(String expenseHeader) {
        this.expenseHeader = expenseHeader;
    }

    /**
     * Gets expense description.
     *
     * @return the expense description
     */
    public String getExpenseDescription() {
        return expenseDescription;
    }

    /**
     * Sets expense description.
     *
     * @param expenseDescription the expense description
     */
    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    /**
     * Gets expense date.
     *
     * @return the expense date
     */
    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    /**
     * Sets expense date.
     *
     * @param expenseDate the expense date
     */
    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    /**
     * Gets expense amount.
     *
     * @return the expense amount
     */
    public int getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * Sets expense amount.
     *
     * @param expenseAmount the expense amount
     */
    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
