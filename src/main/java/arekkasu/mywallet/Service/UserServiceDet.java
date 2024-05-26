package arekkasu.mywallet.Service;

import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The interface User service det.
 */
public interface UserServiceDet extends UserDetailsService {


    /**
     * User register users.
     *
     * @param registerUser the register user
     * @return the users
     */
    public Users UserRegister(RegisterUserDTO registerUser);

    /**
     * User get data users.
     *
     * @param username the username
     * @return the users
     */
    public Users userGetData(String username);




}
