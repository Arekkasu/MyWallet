package arekkasu.mywallet.Service;


import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Model.Roles;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Repository.RolesRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserServiceDet{






    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    //ACCION REGISTRAR
    public Users UserRegister(RegisterUserDTO registerUser){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        String rolName = "ROLE_USER";
        boolean roleExist = rolesRepository.existsByRoleName(rolName);

        if(!roleExist){
            Roles roleAdd = new Roles("ROLE_USER");
            rolesRepository.save(roleAdd);
        }



        Users user = new Users(registerUser.getEmail(), registerUser.getUsername(),
                encoder.encode(registerUser.getPassword()), 0, Arrays.asList(rolesRepository.findByRoleName(rolName)));


        return usersRepository.save(user);

    }


    //ACCION VERIFICAR EXISTENCIA
    public boolean UserExists(String Username){
        return usersRepository.existsByUsername(Username);
    }



    //OBTENER TODA LA INFORMACION DEL USUARIO
    @Override
    public Users userGetData(String username) {
        return usersRepository.findByUsername(username);
    }




    //CREACION DE USUARIO
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if (user == null ){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(user.getUsername(), user.getPassword(), mapearAutoridadesRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Roles> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }




}
