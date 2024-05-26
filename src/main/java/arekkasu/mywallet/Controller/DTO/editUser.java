package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Locale;

/**
 * The type Edit user.
 */
public class editUser {
    @NotNull(message = "{user.username.requerido}")
    @Size(min = 3, max = 20, message = "{user.username.size}")
    private String Username;

    private String Password;

    @NotNull(message = "{user.email.requerido}")
    @Size(min = 3, max = 100, message = "{user.email.size}")
    private String Email;


    /**
     * Instantiates a new Edit user.
     */
    public
    editUser() {
    }

    /**
     * Instantiates a new Edit user.
     *
     * @param username the username
     * @param password the password
     * @param email    the email
     */
    public editUser(String username, String password, String email) {
        Username = username.toLowerCase(Locale.ROOT);
        Password = password;
        Email = email.toLowerCase(Locale.ROOT);
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        Username = username.toLowerCase(Locale.ROOT);
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        Email = email.toLowerCase(Locale.ROOT);
    }
}
