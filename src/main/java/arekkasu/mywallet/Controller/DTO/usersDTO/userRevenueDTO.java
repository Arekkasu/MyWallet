package arekkasu.mywallet.Controller.DTO.usersDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * The type User revenue dto.
 */
public class userRevenueDTO {
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

    /**
     * Instantiates a new User revenue dto.
     */
    public userRevenueDTO() {
    }

    /**
     * Instantiates a new User revenue dto.
     *
     * @param revenueHeader      the revenue header
     * @param revenueDescription the revenue description
     * @param revenueDate        the revenue date
     * @param revenueAmount      the revenue amount
     */
    public userRevenueDTO(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount) {
        this.revenueHeader = revenueHeader;
        this.revenueDescription = revenueDescription;
        this.revenueDate = revenueDate;
        this.revenueAmount = revenueAmount;
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
}
