package arekkasu.mywallet.Controller.DTO.usersDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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

    public userRevenueDTO() {
    }

    public userRevenueDTO(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount) {
        this.revenueHeader = revenueHeader;
        this.revenueDescription = revenueDescription;
        this.revenueDate = revenueDate;
        this.revenueAmount = revenueAmount;
    }

    public String getRevenueHeader() {
        return revenueHeader;
    }

    public void setRevenueHeader(String revenueHeader) {
        this.revenueHeader = revenueHeader;
    }

    public String getRevenueDescription() {
        return revenueDescription;
    }

    public void setRevenueDescription(String revenueDescription) {
        this.revenueDescription = revenueDescription;
    }

    public LocalDate getRevenueDate() {
        return revenueDate;
    }

    public void setRevenueDate(LocalDate revenueDate) {
        this.revenueDate = revenueDate;
    }

    public int getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(int revenueAmount) {
        this.revenueAmount = revenueAmount;
    }
}