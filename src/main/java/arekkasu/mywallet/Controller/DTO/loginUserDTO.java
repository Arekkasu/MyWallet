package arekkasu.mywallet.Controller.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Locale;

public class loginUserDTO {


    private String username;
    private String password;


    public loginUserDTO() {
    }

    public loginUserDTO(String username, String password) {
        this.username = username.toLowerCase(Locale.ROOT);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase(Locale.ROOT);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
