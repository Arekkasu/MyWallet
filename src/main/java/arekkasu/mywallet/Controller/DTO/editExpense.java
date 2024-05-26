package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

/**
 * The type Edit expense.
 */
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

    /**
     * Instantiates a new Edit expense.
     */
    public editExpense() {
    }

    /**
     * Instantiates a new Edit expense.
     *
     * @param idExpense          the id expense
     * @param expenseHeader      the expense header
     * @param expenseDescription the expense description
     * @param expenseDate        the expense date
     * @param expenseAmount      the expense amount
     * @param username           the username
     */
    public editExpense(Long idExpense, String expenseHeader, String expenseDescription, LocalDate expenseDate, int expenseAmount, String username) {
        this.idExpense = idExpense;
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.username = username.toLowerCase(Locale.ROOT);
    }

    /**
     * Gets id expense.
     *
     * @return the id expense
     */
    public Long getIdExpense() {
        return idExpense;
    }

    /**
     * Sets id expense.
     *
     * @param idExpense the id expense
     */
    public void setIdExpense(Long idExpense) {
        this.idExpense = idExpense;
    }

    /**
     * Gets header.
     *
     * @return the header
     */
    public String getexpenseHeader() {
        return expenseHeader;
    }

    /**
     * Sets header.
     *
     * @param expenseHeader the expense header
     */
    public void setexpenseHeader(String expenseHeader) {
        this.expenseHeader = expenseHeader;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getexpenseDescription() {
        return expenseDescription;
    }

    /**
     * Sets description.
     *
     * @param expenseDescription the expense description
     */
    public void setexpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getexpenseDate() {
        return expenseDate;
    }

    /**
     * Sets date.
     *
     * @param expenseDate the expense date
     */
    public void setexpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getexpenseAmount() {
        return expenseAmount;
    }

    /**
     * Sets amount.
     *
     * @param expenseAmount the expense amount
     */
    public void setexpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username.toLowerCase(Locale.ROOT);
    }
}
