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
    private Long idExpenses;
    private String expenseHeader;

    private String expenseDescription;

    private LocalDate expenseDate;

    private int expenseAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Users_IdUsers")
    private Users users;

    public Expenses() {
    }


    public Expenses(Long idExpenses, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, Users users) {
        this.idExpenses = idExpenses;
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.users = users;
    }

    public Expenses(String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, Users users) {
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.users = users;
    }

    public Long getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(Long idExpenses) {
        this.idExpenses = idExpenses;
    }

    public String getExpenseHeader() {
        return expenseHeader;
    }

    public void setExpenseHeader(String expenseHeader) {
        this.expenseHeader = expenseHeader;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
