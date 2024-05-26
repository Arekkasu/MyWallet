package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

public class editRevenue {

    @NotNull
    private Long idRevenue;

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

    public editRevenue() {
    }

    public editRevenue(Long idRevenue, String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, String username) {
        this.idRevenue = idRevenue;
        this.revenueHeader = revenueHeader;
        this.revenueDescription = revenueDescription;
        this.revenueDate = revenueDate;
        this.revenueAmount = revenueAmount;
        this.username = username.toLowerCase(Locale.ROOT);
    }

    public Long getIdRevenue() {
        return idRevenue;
    }

    public void setIdRevenue(Long idRevenue) {
        this.idRevenue = idRevenue;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase(Locale.ROOT);
    }
}
