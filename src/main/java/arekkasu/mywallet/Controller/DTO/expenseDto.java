package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

/**
 * The type Expense dto.
 */
public class expenseDto {
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
     * Instantiates a new Expense dto.
     */
    public expenseDto() {
    }

    /**
     * Instantiates a new Expense dto.
     *
     * @param expenseHeader      the expense header
     * @param expenseDescription the expense description
     * @param expenseDate        the expense date
     * @param expenseAmount      the expense amount
     * @param username           the username
     */
    public expenseDto(String expenseHeader, String expenseDescription,
                      LocalDate expenseDate, int expenseAmount, String username) {
        this.expenseHeader = expenseHeader;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.username = username.toLowerCase(Locale.ROOT);
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
