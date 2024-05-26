package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Locale;

/**
 * The type Login user dto.
 */
public class loginUserDTO {


    private String username;
    private String password;


    /**
     * Instantiates a new Login user dto.
     */
    public loginUserDTO() {
    }

    /**
     * Instantiates a new Login user dto.
     *
     * @param username the username
     * @param password the password
     */
    public loginUserDTO(String username, String password) {
        this.username = username.toLowerCase(Locale.ROOT);
        this.password = password;
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
}
