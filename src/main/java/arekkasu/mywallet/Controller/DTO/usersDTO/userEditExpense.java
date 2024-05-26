package arekkasu.mywallet.Controller.DTO.usersDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class userEditExpense {
    @NotNull
    private Long idExpense;

    @NotEmpty(message = "{expense.header.requerido}")
    private String expenseHeader;

    @NotEmpty(message = "{expense.description.requerido}")
    private String expenseDescription;

    @NotNull(message = "{expense.date.requerido}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expenseDate;

    @NotNull(message = "{expense.amount.requerido}")
    @Min(value = 1, message = "{expense.amount.min}")
    private int expenseAmount;


    public userEditExpense() {
    }

    public userEditExpense(Long idExpense, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount) {
        this.idExpense = idExpense;
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
    }

    public Long getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Long idExpense) {
        this.idExpense = idExpense;
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
}
