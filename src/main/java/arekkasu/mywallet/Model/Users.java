package arekkasu.mywallet.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class Users {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idUsers;

        @NotNull(message = "Email is required")
        private String email;

        @NotNull(message = "Username is required")
        private String username;

        @NotNull(message = "Password is required")
        private String password;

        private int totalAmount;

        //RELACION DE ROLES
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "IdUsers", referencedColumnName = "IdUsers"),
                inverseJoinColumns = @JoinColumn(name = "IdRole", referencedColumnName = "IdRole")

        )
        private Collection<Roles> roles;


        //RELACION DE INGRESOS

        @OneToMany(mappedBy = "users",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonBackReference
        private List<Revenue> revenue;

        //RELACION DE EGRESOS

        @OneToMany(mappedBy = "users",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonBackReference
        private List<Expenses> expenses;


        public Users() {
        }

        public Users(Long idUsers, String email, String username, String password,
                     int totalAmount, Collection<Roles> roles,
                     List<Revenue> revenue, List<Expenses> expenses) {
                this.idUsers = idUsers;
                this.email = email;
                this.username = username;
                this.password = password;
                this.totalAmount = totalAmount;
                this.roles = roles;
                this.revenue = revenue;
                this.expenses = expenses;
        }

        public Users(String email, String username, String password, int totalAmount,
                     Collection<Roles> roles, List<Revenue> revenue, List<Expenses> expenses) {
                this.email = email;
                this.username = username;
                this.password = password;
                this.totalAmount = totalAmount;
                this.roles = roles;
                this.revenue = revenue;
                this.expenses = expenses;
        }

        public Users(String email, String username, String password,
                     int totalAmount,
                     Collection<arekkasu.mywallet.Model.Roles> roles) {
                this.email = email;
                this.username = username;
                this.password = password;
                this.totalAmount = totalAmount;
                this.roles = roles;
        }

        public Long getIdUsers() {
                return idUsers;
        }

        public void setIdUsers(Long idUsers) {
                this.idUsers = idUsers;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getTotalAmount() {
                return totalAmount;
        }

        public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
        }

        public Collection<Roles> getRoles() {
                return roles;
        }

        public void setRoles(Collection<Roles> roles) {
                this.roles = roles;
        }

        public List<Revenue> getRevenue() {
                return revenue;
        }

        public void setRevenue(List<Revenue> revenue) {
                this.revenue = revenue;
        }

        public List<Expenses> getExpenses() {
                return expenses;
        }

        public void setExpenses(List<Expenses> expenses) {
                this.expenses = expenses;
        }
}
