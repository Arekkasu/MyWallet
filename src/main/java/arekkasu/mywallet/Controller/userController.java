package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Controller.DTO.editExpense;
import arekkasu.mywallet.Controller.DTO.editRevenue;
import arekkasu.mywallet.Controller.DTO.expenseDto;
import arekkasu.mywallet.Controller.DTO.revenueDto;
import arekkasu.mywallet.Controller.DTO.usersDTO.userEditExpense;
import arekkasu.mywallet.Controller.DTO.usersDTO.userEditRevenue;
import arekkasu.mywallet.Controller.DTO.usersDTO.userExpenseDTO;
import arekkasu.mywallet.Controller.DTO.usersDTO.userRevenueDTO;
import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type User controller.
 */
@Controller
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    private UsersService usersService;


    /**
     * User home string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String userHome(Model model) {

        String userLogged = SecurityContextHolder.getContext().getAuthentication().getName();

        //OBTENIENDO LOS ROLES

        Users userInfo = usersService.userGetData(userLogged);


        Set<String> userRole = userInfo.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
        System.out.println(userRole);
        if (userRole.contains("ROLE_ADMIN")) {

            return "redirect:/admin/users";
        }

        model.addAttribute("user", userInfo);

        return "secure/users/userHome";
    }


    /**
     * User expense string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/expenses")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String userExpense(Model model) {

        model.addAttribute("expense", new userExpenseDTO());
        return "secure/users/userExpense";
    }

    /**
     * User expense string.
     *
     * @param userExpenseDTO the user expense dto
     * @param bindingResult  the binding result
     * @param model          the model
     * @return the string
     */
    @PostMapping("/expenses")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String userExpense(@ModelAttribute("expense") @Valid userExpenseDTO userExpenseDTO,
                              BindingResult bindingResult, Model model) {

        System.out.println("inicio");
        if (bindingResult.hasErrors()) {
            System.out.println("errores");
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/users/userExpense";
        }

        System.out.println("succes");
        usersService.saveExpense(userExpenseDTO);

        model.addAttribute("messageSucces", "Gasto registrado con exito");

        return "secure/users/userExpense";
    }


    /**
     * Edit expenses string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/expenses/edit/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String editExpenses(@PathVariable("id") Long id, Model model) {

        model.addAttribute("expenseDTO", new userEditExpense());
        Expenses expense = usersService.findExpenseById(id);
        model.addAttribute("expense", expense);
        return "secure/users/editExpense";
    }


    /**
     * Edit expenses string.
     *
     * @param id            the id
     * @param editExpense   the edit expense
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @PostMapping("/expenses/edit/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String editExpenses(@PathVariable("id") Long id, @ModelAttribute("expenseDTO") @Valid userEditExpense editExpense,
                               BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("ACA NO");
            for (ObjectError error : bindingResult.getAllErrors()) {
                if (error instanceof FieldError) {
                    System.out.println(((FieldError) error).getField() + ": " + error.getDefaultMessage());
                } else {
                    System.out.println(error.getDefaultMessage());
                }
            }
            Expenses expense = usersService.findExpenseById(id);
            model.addAttribute("expense", expense);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/users/editExpense";
        }


        usersService.saveEditExpense(editExpense);
        return "redirect:/user/expenses";
    }


    //REVENUES

    /**
     * User revenues string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/revenues")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String userRevenues(Model model) {
        model.addAttribute("revenue", new userRevenueDTO());
        return "secure/users/userRevenue";
    }

    /**
     * User revenues string.
     *
     * @param revenueDto    the revenue dto
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @PostMapping("/revenues")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String userRevenues(@ModelAttribute("revenue") @Valid userRevenueDTO revenueDto,
                               BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/users/userRevenue";
        }


        usersService.saveRevenue(revenueDto);
        model.addAttribute("messageSucces", "Ingreso registrado con exito");
        return "secure/users/userRevenue";
    }


    /**
     * Edit revenues string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/revenues/edit/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String editRevenues(@PathVariable("id") Long id, Model model){
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        model.addAttribute("revenueDTO", new userEditRevenue());
        Revenue revenue = usersService.findRevenueById(id);
        model.addAttribute("revenue", revenue);
        return "secure/users/editRevenue";
    }

    /**
     * Admin revenues string.
     *
     * @param id            the id
     * @param editRevenue   the edit revenue
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @PostMapping("/revenues/edit/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String adminRevenues(@PathVariable("id") Long id,@ModelAttribute("revenueDTO") @Valid userEditRevenue editRevenue,
                                BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            Revenue revenue = usersService.findRevenueById(id);
            model.addAttribute("revenue", revenue);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secure/users/editRevenue";
        }

        usersService.saveEditRevenue(editRevenue);

        return "redirect:/user/revenues";
    }






}
