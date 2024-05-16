package arekkasu.mywallet.Model;


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
        private Long IdRevenue;

        private String RevenueHeader;

        private String RevenueDescription;

        private LocalDate RevenueDate;

        private int RevenueAmount;

        @ManyToOne( cascade = CascadeType.ALL)
        @JoinColumn(name = "Users_IdUsers")
        private Users Users;

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
         */
        public Revenue(Long idRevenue, String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount) {
                IdRevenue = idRevenue;
                RevenueHeader = revenueHeader;
                RevenueDescription = revenueDescription;
                RevenueDate = revenueDate;
                RevenueAmount = revenueAmount;
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
        public Revenue(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount,
                       Users users) {
                RevenueHeader = revenueHeader;
                RevenueDescription = revenueDescription;
                RevenueDate = revenueDate;
                RevenueAmount = revenueAmount;
                Users = users;
        }

        /**
         * Gets id revenue.
         *
         * @return the id revenue
         */
        public Long getIdRevenue() {
                return IdRevenue;
        }

        /**
         * Sets id revenue.
         *
         * @param idRevenue the id revenue
         */
        public void setIdRevenue(Long idRevenue) {
                IdRevenue = idRevenue;
        }

        /**
         * Gets revenue header.
         *
         * @return the revenue header
         */
        public String getRevenueHeader() {
                return RevenueHeader;
        }

        /**
         * Sets revenue header.
         *
         * @param revenueHeader the revenue header
         */
        public void setRevenueHeader(String revenueHeader) {
                RevenueHeader = revenueHeader;
        }

        /**
         * Gets revenue description.
         *
         * @return the revenue description
         */
        public String getRevenueDescription() {
                return RevenueDescription;
        }

        /**
         * Sets revenue description.
         *
         * @param revenueDescription the revenue description
         */
        public void setRevenueDescription(String revenueDescription) {
                RevenueDescription = revenueDescription;
        }

        /**
         * Gets revenue date.
         *
         * @return the revenue date
         */
        public LocalDate getRevenueDate() {
                return RevenueDate;
        }

        /**
         * Sets revenue date.
         *
         * @param revenueDate the revenue date
         */
        public void setRevenueDate(LocalDate revenueDate) {
                RevenueDate = revenueDate;
        }

        /**
         * Gets revenue amount.
         *
         * @return the revenue amount
         */
        public int getRevenueAmount() {
                return RevenueAmount;
        }

        /**
         * Sets revenue amount.
         *
         * @param revenueAmount the revenue amount
         */
        public void setRevenueAmount(int revenueAmount) {
                RevenueAmount = revenueAmount;
        }

        /**
         * Gets users.
         *
         * @return the users
         */
        public Users getUsers() {
                return Users;
        }

        /**
         * Sets users.
         *
         * @param users the users
         */
        public void setUsers(Users users) {
                Users = users;
        }
}
