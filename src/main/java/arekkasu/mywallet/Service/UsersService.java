package arekkasu.mywallet.Service;


import arekkasu.mywallet.Controller.DTO.RegisterUser;
import arekkasu.mywallet.Model.Roles;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Repository.RolesRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsersService {


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;

    //ACCION REGISTRAR
    public Users UserRegister(RegisterUser registerUser){

        String rolName = "ROLE_USER";
        boolean roleExist = rolesRepository.existsByRoleName(rolName);

        if(!roleExist){
            Roles roleAdd = new Roles("ROLE_USER");
            rolesRepository.save(roleAdd);
        }



        Users user = new Users(registerUser.getEmail(), registerUser.getUsername(),
                registerUser.getPassword(), 0, Arrays.asList(rolesRepository.findByRoleName(rolName)));


        return usersRepository.save(user);

    }

    //ACCION VERIFICAR EXISTENCIA
    public boolean UserExists(String Username){
        return usersRepository.existsByUsername(Username);
    }






}
