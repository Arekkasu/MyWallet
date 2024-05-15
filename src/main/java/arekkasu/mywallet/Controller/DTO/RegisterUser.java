package arekkasu.mywallet.Controller.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUser {


    @NotNull(message = "Username is required")
    @Size(min = 3, max = 20)
    private String Username;

    @NotNull(message = "Password is required")
    @Size(min = 3, max = 20)
    private String Password;

    @NotNull(message = "Email is required")
    @Size(min = 3, max = 20)
    private String Email;


    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String email) {
        Username = username;
        Password = password;
        Email = email;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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
        Email = email;
    }
}
