package arekkasu.mywallet.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.Date;

/**
 * The type Revenue.
 */
@Entity
@Table(name = "revenue")
public class Revenue {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idRevenue;

        private String revenueHeader;

        private String revenueDescription;

        private LocalDate revenueDate;

        private int revenueAmount;

        @ManyToOne
        @JoinColumn(name = "Users_IdUsers")
        @JsonManagedReference
        private Users users;

    /**
     * Instantiates a new Revenue.
     */
    public Revenue() {
        }

    /**
     * Instantiates a new Revenue.
     *
     * @param idRevenue          the id revenue
     * @param revenueHeader      the revenue header
     * @param revenueDescription the revenue description
     * @param revenueDate        the revenue date
     * @param revenueAmount      the revenue amount
     * @param users              the users
     */
    public Revenue(Long idRevenue, String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, Users users) {
                this.idRevenue = idRevenue;
                this.revenueHeader = revenueHeader;
                this.revenueDescription = revenueDescription;
                this.revenueDate = revenueDate;
                this.revenueAmount = revenueAmount;
                this.users = users;
        }


    /**
     * Instantiates a new Revenue.
     *
     * @param revenueHeader      the revenue header
     * @param revenueDescription the revenue description
     * @param revenueDate        the revenue date
     * @param revenueAmount      the revenue amount
     * @param users              the users
     */
    public Revenue(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, Users users) {
                this.revenueHeader = revenueHeader;
                this.revenueDescription = revenueDescription;
                this.revenueDate = revenueDate;
                this.revenueAmount = revenueAmount;
                this.users = users;
        }


    /**
     * Gets id revenue.
     *
     * @return the id revenue
     */
    public Long getIdRevenue() {
                return idRevenue;
        }

    /**
     * Sets id revenue.
     *
     * @param idRevenue the id revenue
     */
    public void setIdRevenue(Long idRevenue) {
                this.idRevenue = idRevenue;
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
     * Gets users.
     *
     * @return the users
     */
    public Users getUsers() {
                return users;
        }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Users users) {
                this.users = users;
        }
}
