package arekkasu.mywallet.Controller.DTO;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Locale;

/**
 * The type Register user dto.
 */
public class RegisterUserDTO {


    @NotNull(message = "{user.username.requerido}")
    @Size(min = 3, max = 20, message = "{user.username.size}")
    private String Username;

    @NotNull(message = "{user.password.required}")
    @Size(min = 10, message = "{user.password.size}")
    private String Password;

    @NotNull(message = "{user.email.requerido}")
    @Size(min = 3, max = 100, message = "{user.email.size}")
    private String Email;


    /**
     * Instantiates a new Register user dto.
     */
    public
    RegisterUserDTO() {
    }

    /**
     * Instantiates a new Register user dto.
     *
     * @param username the username
     * @param password the password
     * @param email    the email
     */
    public RegisterUserDTO(String username, String password, String email) {
        this.Username = username.toLowerCase(Locale.ROOT);
        this.Password = password;
        this.Email = email.toLowerCase(Locale.ROOT);
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
