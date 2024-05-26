package arekkasu.mywallet.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.Collection;
import java.util.List;

/**
 * The type Users.
 */
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


    /**
     * Instantiates a new Users.
     */
    public Users() {
        }

    /**
     * Instantiates a new Users.
     *
     * @param idUsers     the id users
     * @param email       the email
     * @param username    the username
     * @param password    the password
     * @param totalAmount the total amount
     * @param roles       the roles
     * @param revenue     the revenue
     * @param expenses    the expenses
     */
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

    /**
     * Instantiates a new Users.
     *
     * @param email       the email
     * @param username    the username
     * @param password    the password
     * @param totalAmount the total amount
     * @param roles       the roles
     * @param revenue     the revenue
     * @param expenses    the expenses
     */
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

    /**
     * Instantiates a new Users.
     *
     * @param email       the email
     * @param username    the username
     * @param password    the password
     * @param totalAmount the total amount
     * @param roles       the roles
     */
    public Users(String email, String username, String password,
                     int totalAmount,
                     Collection<arekkasu.mywallet.Model.Roles> roles) {
                this.email = email;
                this.username = username;
                this.password = password;
                this.totalAmount = totalAmount;
                this.roles = roles;
        }

    /**
     * Gets id users.
     *
     * @return the id users
     */
    public Long getIdUsers() {
                return idUsers;
        }

    /**
     * Sets id users.
     *
     * @param idUsers the id users
     */
    public void setIdUsers(Long idUsers) {
                this.idUsers = idUsers;
        }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
                return email;
        }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
                this.email = email;
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
                this.username = username;
        }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
                return password;
        }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
                this.password = password;
        }

    /**
     * Gets total amount.
     *
     * @return the total amount
     */
    public int getTotalAmount() {
                return totalAmount;
        }

    /**
     * Sets total amount.
     *
     * @param totalAmount the total amount
     */
    public void setTotalAmount(int totalAmount) {
                this.totalAmount = totalAmount;
        }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Collection<Roles> getRoles() {
                return roles;
        }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Collection<Roles> roles) {
                this.roles = roles;
        }

    /**
     * Gets revenue.
     *
     * @return the revenue
     */
    public List<Revenue> getRevenue() {
                return revenue;
        }

    /**
     * Sets revenue.
     *
     * @param revenue the revenue
     */
    public void setRevenue(List<Revenue> revenue) {
                this.revenue = revenue;
        }

    /**
     * Gets expenses.
     *
     * @return the expenses
     */
    public List<Expenses> getExpenses() {
                return expenses;
        }

    /**
     * Sets expenses.
     *
     * @param expenses the expenses
     */
    public void setExpenses(List<Expenses> expenses) {
                this.expenses = expenses;
        }
}
