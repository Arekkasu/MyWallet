package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

public class editExpense {
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

    @NotEmpty(message = "{expense.username.requerido}")
    private String username;

    public editExpense() {
    }

    public editExpense(Long idExpense, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, String username) {
        this.idExpense = idExpense;
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.username = username.toLowerCase(Locale.ROOT);
    }

    public Long getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Long idExpense) {
        this.idExpense = idExpense;
    }

    public String getexpenseHeader() {
        return expenseHeader;
    }

    public void setexpenseHeader(String expenseHeader) {
        this.expenseHeader = expenseHeader;
    }

    public String getexpenseDescription() {
        return expenseDescription;
    }

    public void setexpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public LocalDate getexpenseDate() {
        return expenseDate;
    }

    public void setexpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public int getexpenseAmount() {
        return expenseAmount;
    }

    public void setexpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase(Locale.ROOT);
    }
}
