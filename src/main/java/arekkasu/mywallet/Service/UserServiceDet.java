package arekkasu.mywallet.Service;

import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceDet extends UserDetailsService {


    public Users UserRegister(RegisterUserDTO registerUser);

    public Users userGetData(String username);




}
