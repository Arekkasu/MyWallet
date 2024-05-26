package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Controller.DTO.*;
import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Service.ApiRestServices.AdminService;
import arekkasu.mywallet.Service.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class adminController {

    @Autowired
    private AdminService adminService;



    @GetMapping("/users")
    public String adminUsers(Model model){
        model.addAttribute("registerUser", new RegisterUserDTO());
        return "secure/admin/adminUsers";
    }

    @PostMapping("/users")
    public String adminUsers(@ModelAttribute("registerUser") @Valid RegisterUserDTO registerUser,
                             BindingResult bindingResult, Model model){
        boolean userExists = adminService.existsByUsername(registerUser.getUsername());

        if(bindingResult.hasErrors()){

            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(model.getAttribute("errors"));
            return "secure/admin/adminUsers";
        }

        if(userExists){
            model.addAttribute("userExists", "El usuario ya existe");
            return "secure/admin/adminUsers";
        }


        model.addAttribute("messageSucces", "Usuario Registrado con exito");
        adminService.UserRegister(registerUser);

        return "secure/admin/adminUsers";
    }





    //RUTAS DE EXPENSES

    @GetMapping("/expenses")
    public String adminExpenses(Model model){

        model.addAttribute("expense", new expenseDto());
        return "secure/admin/adminExpenses";
    }

    @PostMapping("/expenses")
    public String adminExpenses(@ModelAttribute("expense") @Valid expenseDto expenseDto,
                                BindingResult bindingResult, Model model) {

        boolean userExists = adminService.existsByUsername(expenseDto.getUsername());
        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/admin/adminExpenses";
        }

        if(!userExists){
            model.addAttribute("userExists", "El usuario no existe");
            System.out.println(expenseDto.getExpenseDate());
            return "secure/admin/adminExpenses";
        }

        adminService.saveExpense(expenseDto);

        model.addAttribute("messageSucces", "Gasto registrado con exito");

        return "secure/admin/adminExpenses";
    }


    @GetMapping("/expenses/edit/{id}")
    public String editExpenses(@PathVariable("id") Long id, Model model){

        model.addAttribute("expenseDTO", new editExpense());
        Expenses expense = adminService.findExpenseById(id);
        model.addAttribute("expense", expense);
        return "secure/admin/editExpense";
    }


    @PostMapping("/expenses/edit/{id}")
    public String editExpenses(@PathVariable("id") Long id,@ModelAttribute("expenseDTO") @Valid editExpense editExpense,
                                BindingResult bindingResult, Model model) {

        boolean userExists = adminService.existsByUsername(editExpense.getUsername());
        if (bindingResult.hasErrors()) {
            System.out.println("ACA NO");
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (error instanceof FieldError) {
                    System.out.println(((FieldError) error).getField() + ": " + error.getDefaultMessage());
                } else {
                    System.out.println(error.getDefaultMessage());
                }
            }
            Expenses expense = adminService.findExpenseById(id);
            model.addAttribute("expense", expense);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/admin/editExpense";
        }
        if(!userExists){
            System.out.println("EXIST USER");
            model.addAttribute("userExists", "El usuario no existe");
            System.out.println(editExpense.getexpenseDate());
            return "secure/admin/editExpense";
        }


        adminService.saveEditExpense(editExpense);
        return "redirect:/admin/expenses";
    }







    //RUTAS DE REVENUE

    @GetMapping("/revenues")
    public String adminRevenues(Model model){
        model.addAttribute("revenue", new revenueDto());
        return "secure/admin/adminRevenues";
    }

    @PostMapping("/revenues")
    public String adminRevenues(@ModelAttribute("revenue") @Valid revenueDto revenueDto,
                                BindingResult bindingResult, Model model) {

        boolean userExists = adminService.existsByUsername(revenueDto.getUsername());
        if (bindingResult.hasErrors()) {

            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/admin/adminRevenues";
        }

        if(!userExists){
            model.addAttribute("userExists", "El usuario no existe");
            System.out.println(revenueDto.getRevenueDate());
            return "secure/admin/adminRevenues";
        }

        adminService.saveRevenue(revenueDto);

        model.addAttribute("messageSucces", "Ingreso registrado con exito");


        return "secure/admin/adminRevenues";
    }

    @GetMapping("/revenues/edit/{id}")
    public String editRevenues(@PathVariable("id") Long id, Model model){
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        model.addAttribute("revenueDTO", new editRevenue());
        Revenue revenue = adminService.findRevenueById(id);
        model.addAttribute("revenue", revenue);
        return "secure/admin/editRevenue";
    }

    @PostMapping("/revenues/edit/{id}")
    public String adminRevenues(@PathVariable("id") Long id,@ModelAttribute("revenueDTO") @Valid editRevenue editRevenue,
                                BindingResult bindingResult, Model model) {

        boolean userExists = adminService.existsByUsername(editRevenue.getUsername());
        if (bindingResult.hasErrors()) {
            System.out.println("ACA NO");
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (error instanceof FieldError) {
                    System.out.println(((FieldError) error).getField() + ": " + error.getDefaultMessage());
                } else {
                    System.out.println(error.getDefaultMessage());
                }
            }
            Revenue revenue = adminService.findRevenueById(id);
            model.addAttribute("revenue", revenue);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/admin/editRevenue";
        }

        if(!userExists){
            System.out.println("EXIST USER");
            model.addAttribute("userExists", "El usuario no existe");
            System.out.println(editRevenue.getRevenueDate());
            return "secure/admin/editRevenue";
        }


        System.out.println("SERA ACA?");
        adminService.saveEditRevenue(editRevenue);

        return "redirect:/admin/revenues";
    }



    //-------------------

    //EDITAR USUARIOS

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        model.addAttribute("editUser", new editUser());
        Users user = adminService.findUserByIdUsers(id);
        model.addAttribute("user", user);
        return "secure/admin/editUser";
    }

    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, @ModelAttribute("editUser") @Valid editUser user,
                           BindingResult bindingResult, Model model){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(model.getAttribute("errors"));
            Users userOld = adminService.findUserByIdUsers(id);
            model.addAttribute("user", userOld);
            return "secure/admin/editUser";
        }

        Users userOld = adminService.findUserByIdUsers(id);

        userOld.setUsername(user.getUsername());
        if (!user.getPassword().isEmpty()) {
            userOld.setPassword(encoder.encode(user.getPassword()));
        }
        userOld.setEmail(user.getEmail());

        adminService.saveUser(userOld);




        return "redirect:/admin/users";
    }





}
