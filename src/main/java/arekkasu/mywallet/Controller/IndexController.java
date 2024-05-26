package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Controller.DTO.loginUserDTO;
import arekkasu.mywallet.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping
    public String indexPage(){
        return "index";
    }

    @GetMapping("register")
    public String registerPage(Model model){

        model.addAttribute("registerUser", new RegisterUserDTO());
        //usersService.UserRegister();
        return "register";
    }


    @PostMapping("register")
    public String registerUser(@ModelAttribute("registerUser") @Valid RegisterUserDTO registerUser, BindingResult bindingResult, Model model){

        boolean userExists = usersService.UserExists(registerUser.getUsername());

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(model.getAttribute("errors"));
            return "register";
        }

        if(userExists){
            model.addAttribute("userExists", "El usuario ya existe");
            return "register";
        }


        model.addAttribute("messageSucces", "Usuario Registrado con exito");
        usersService.UserRegister(registerUser);
        return "register";
    }









    @GetMapping("login")
    public String loginPage(@RequestParam(value = "logout", required = false) String string,@RequestParam(value = "error", required = false)String error, Model model){
        if(error != null){
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
        }
        model.addAttribute("loginUser", new loginUserDTO());
        return "login";

    }



    @PostMapping("login")
    public String loginPagePost(@ModelAttribute("loginUser") loginUserDTO loginUser, Model model){
        try {

            UserDetails userDetails = usersService.loadUserByUsername(loginUser.getUsername());
            System.out.println(userDetails);
            if (passwordEncoder.matches(loginUser.getPassword(), userDetails.getPassword())) {
                // Autenticación exitosa, redirigir al usuario a la página de inicio
                return "redirect:/user";
            } else {
                // La contraseña es incorrecta, mostrar un mensaje de error
                model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
                return "login";
            }
        } catch (UsernameNotFoundException e) {
            // El nombre de usuario no existe, mostrar un mensaje de error
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }

}
