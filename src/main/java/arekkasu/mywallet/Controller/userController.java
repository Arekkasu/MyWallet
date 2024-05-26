package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UsersService usersService;



    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String userHome(){

        String userLogged = SecurityContextHolder.getContext().getAuthentication().getName();

        //OBTENIENDO LOS ROLES

        Users userInfo = usersService.userGetData(userLogged);


        Set<String> userRole = userInfo.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toSet());

        if (userRole.contains("ROLE_ADMIN")){
            return "secure/admin/adminHome";
        }


        System.out.println(userRole);



        return "secure/users/userHome";
    }


}
