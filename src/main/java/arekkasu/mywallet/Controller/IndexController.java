package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * The type Index controller.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UsersService usersService;

    /**
     * Index page string.
     *
     * @return the index.jsp
     */
    @GetMapping
    public String indexPage(){
        return "index";
    }


    /**
     * Register page string.
     *
     * @return the register.jsp
     */
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









    /**
     * Login page string.
     *
     * @return the Login.jsp
     */
    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    /**
     * Faq page string.
     *
     * @return the FAQ.jsp
     */
    @GetMapping("FAQ")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String FAQPage(){
        return "FAQ";
    }


    


}
