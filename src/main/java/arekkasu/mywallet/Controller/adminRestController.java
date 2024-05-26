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

@Controller
@RestController
@RequestMapping("/adminAPI")
public class adminRestController {


    @Autowired
    private AdminService adminService;


    //LISTADO GENERAL DE USUARIOS, GASTOS E INGRESOS
    @GetMapping("/usersList")
    public List<Users> usersList(){
            return adminService.usersList();
    }

    @GetMapping("/expensesList")
    public List<Expenses> expensesList(){
        return adminService.findAllExpenses();
    }


    @GetMapping("/revenuesList")
    public List<Revenue> revenuesList(){
        return adminService.findAllRevenues();
    }


    //BUSQUEDA DE USUARIOS, GASTOS E INGRESOS POR ID







    //DELETE MAPPINGS
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        adminService.deleteUser(id);
    }

    @DeleteMapping("/deleteExpense/{id}")
    public void deleteExpense(@PathVariable("id") Long id){
        adminService.deleteExpense(id);
    }

    @DeleteMapping("/deleteRevenue/{id}")
    public void deleteRevenue(@PathVariable("id") Long id){
        adminService.deleteRevenue(id);
    }

}
