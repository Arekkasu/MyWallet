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
        private Long idRevenue;

        private String revenueHeader;

        private String revenueDescription;

        private LocalDate revenueDate;

        private int revenueAmount;

        @ManyToOne( cascade = CascadeType.ALL)
        @JoinColumn(name = "Users_IdUsers")
        private Users users;

        public Revenue() {
        }

        public Revenue(Long idRevenue, String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, Users users) {
                this.idRevenue = idRevenue;
                this.revenueHeader = revenueHeader;
                this.revenueDescription = revenueDescription;
                this.revenueDate = revenueDate;
                this.revenueAmount = revenueAmount;
                this.users = users;
        }


        public Revenue(String revenueHeader, String revenueDescription, LocalDate revenueDate, int revenueAmount, Users users) {
                this.revenueHeader = revenueHeader;
                this.revenueDescription = revenueDescription;
                this.revenueDate = revenueDate;
                this.revenueAmount = revenueAmount;
                this.users = users;
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

        public Users getUsers() {
                return users;
        }

        public void setUsers(Users users) {
                this.users = users;
        }
}
