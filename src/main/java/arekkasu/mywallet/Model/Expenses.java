package arekkasu.mywallet.Model;


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
    private Long IdExpenses;
    private String ExpenseHeader;

    private String ExpenseDescription;

    private LocalDate ExpenseDate;

    private int ExpenseAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Users_IdUsers")
    private Users Users;


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
    public Expenses(Long idExpenses, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount,
                    Users users) {
        IdExpenses = idExpenses;
        ExpenseHeader = expenseHeader;
        ExpenseDescription = expenseDescription;
        ExpenseDate = expenseDate;
        ExpenseAmount = expenseAmount;
        Users = users;
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
    public Expenses(String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, arekkasu.mywallet.Model.Users users) {
        ExpenseHeader = expenseHeader;
        ExpenseDescription = expenseDescription;
        ExpenseDate = expenseDate;
        ExpenseAmount = expenseAmount;
        Users = users;
    }

    /**
     * Gets id expenses.
     *
     * @return the id expenses
     */
    public Long getIdExpenses() {
        return IdExpenses;
    }

    /**
     * Sets id expenses.
     *
     * @param idExpenses the id expenses
     */
    public void setIdExpenses(Long idExpenses) {
        IdExpenses = idExpenses;
    }

    /**
     * Gets expense header.
     *
     * @return the expense header
     */
    public String getExpenseHeader() {
        return ExpenseHeader;
    }

    /**
     * Sets expense header.
     *
     * @param expenseHeader the expense header
     */
    public void setExpenseHeader(String expenseHeader) {
        ExpenseHeader = expenseHeader;
    }

    /**
     * Gets expense description.
     *
     * @return the expense description
     */
    public String getExpenseDescription() {
        return ExpenseDescription;
    }

    /**
     * Sets expense description.
     *
     * @param expenseDescription the expense description
     */
    public void setExpenseDescription(String expenseDescription) {
        ExpenseDescription = expenseDescription;
    }

    /**
     * Gets expense date.
     *
     * @return the expense date
     */
    public LocalDate getExpenseDate() {
        return ExpenseDate;
    }

    /**
     * Sets expense date.
     *
     * @param expenseDate the expense date
     */
    public void setExpenseDate(LocalDate expenseDate) {
        ExpenseDate = expenseDate;
    }

    /**
     * Gets expense amount.
     *
     * @return the expense amount
     */
    public int getExpenseAmount() {
        return ExpenseAmount;
    }

    /**
     * Sets expense amount.
     *
     * @param expenseAmount the expense amount
     */
    public void setExpenseAmount(int expenseAmount) {
        ExpenseAmount = expenseAmount;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Users getUsers() {
        return Users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Users users) {
        Users = users;
    }
}
