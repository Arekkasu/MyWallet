package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Service.ApiRestServices.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin rest controller.
 */
@Controller
@RestController
@RequestMapping("/adminAPI")
public class adminRestController {


    @Autowired
    private AdminService adminService;


    /**
     * Users list list.
     *
     * @return the list
     */
//LISTADO GENERAL DE USUARIOS, GASTOS E INGRESOS
    @GetMapping("/usersList")
    public List<Users> usersList(){
            return adminService.usersList();
    }

    /**
     * Expenses list list.
     *
     * @return the list
     */
    @GetMapping("/expensesList")
    public List<Expenses> expensesList(){
        return adminService.findAllExpenses();
    }


    /**
     * Revenues list list.
     *
     * @return the list
     */
    @GetMapping("/revenuesList")
    public List<Revenue> revenuesList(){
        return adminService.findAllRevenues();
    }


    //BUSQUEDA DE USUARIOS, GASTOS E INGRESOS POR ID


    /**
     * Delete user.
     *
     * @param id the id
     */
//DELETE MAPPINGS
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        adminService.deleteUser(id);
    }

    /**
     * Delete expense.
     *
     * @param id the id
     */
    @DeleteMapping("/deleteExpense/{id}")
    public void deleteExpense(@PathVariable("id") Long id){
        adminService.deleteExpense(id);
    }

    /**
     * Delete revenue.
     *
     * @param id the id
     */
    @DeleteMapping("/deleteRevenue/{id}")
    public void deleteRevenue(@PathVariable("id") Long id){
        adminService.deleteRevenue(id);
    }

}
