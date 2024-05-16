package arekkasu.mywallet.Controller.DTO;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterUserDTO {


    @NotNull(message = "Username is required")
    @Size(min = 3, max = 20)
    private String Username;

    @NotNull(message = "Password is required")
    @Size(min = 3, max = 20)
    private String Password;

    @NotNull(message = "Email is required")
    @Size(min = 3, max = 20)
    private String Email;


    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String username, String password, String email) {
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
