package arekkasu.mywallet.Controller.DTO;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Locale;

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


    public
    RegisterUserDTO() {
    }

    public RegisterUserDTO(String username, String password, String email) {
        this.Username = username.toLowerCase(Locale.ROOT);
        this.Password = password;
        this.Email = email.toLowerCase(Locale.ROOT);
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username.toLowerCase(Locale.ROOT);
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email.toLowerCase(Locale.ROOT);
    }
}
