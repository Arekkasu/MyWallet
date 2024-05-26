package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

/**
 * The type Revenue dto.
 */
public class revenueDto {


    @NotEmpty(message = "{revenue.header.requerido}")
    private String revenueHeader;

    @NotEmpty(message = "{revenue.description.requerido}")
    private String revenueDescription;

    @NotNull(message = "{revenue.date.requerido}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate revenueDate;

    @NotNull(message = "{revenue.amount.requerido}")
    @Min(value = 1, message = "{revenue.amount.min}")
    private int revenueAmount;

    @NotEmpty(message = "{revenue.username.requerido}")
    private String username;

    /**
     * Instantiates a new Revenue dto.
     */
    public revenueDto() {
    }

    /**
     * Instantiates a new Revenue dto.
     *
     * @param revenueHeader      the revenue header
     * @param revenueDescription the revenue description
     * @param revenueDate        the revenue date
     * @param revenueAmount      the revenue amount
     * @param username           the username
     */
    public revenueDto(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, String username) {
        this.revenueHeader = revenueHeader;
        this.revenueDescription = revenueDescription;
        this.revenueDate = revenueDate;
        this.revenueAmount = revenueAmount;
        this.username = username.toLowerCase(Locale.ROOT);
    }

    /**
     * Gets revenue header.
     *
     * @return the revenue header
     */
    public String getRevenueHeader() {
        return revenueHeader;
    }

    /**
     * Sets revenue header.
     *
     * @param revenueHeader the revenue header
     */
    public void setRevenueHeader(String revenueHeader) {
        this.revenueHeader = revenueHeader;
    }

    /**
     * Gets revenue description.
     *
     * @return the revenue description
     */
    public String getRevenueDescription() {
        return revenueDescription;
    }

    /**
     * Sets revenue description.
     *
     * @param revenueDescription the revenue description
     */
    public void setRevenueDescription(String revenueDescription) {
        this.revenueDescription = revenueDescription;
    }

    /**
     * Gets revenue date.
     *
     * @return the revenue date
     */
    public LocalDate getRevenueDate() {
        return revenueDate;
    }

    /**
     * Sets revenue date.
     *
     * @param revenueDate the revenue date
     */
    public void setRevenueDate(LocalDate revenueDate) {
        this.revenueDate = revenueDate;
    }


    /**
     * Gets revenue amount.
     *
     * @return the revenue amount
     */
    public int getRevenueAmount() {
        return revenueAmount;
    }

    /**
     * Sets revenue amount.
     *
     * @param revenueAmount the revenue amount
     */
    public void setRevenueAmount(int revenueAmount) {
        this.revenueAmount = revenueAmount;
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
