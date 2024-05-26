package arekkasu.mywallet.Service.ApiRestServices;


import arekkasu.mywallet.Controller.DTO.*;
import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Model.Roles;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Repository.ExpensesRepository;
import arekkasu.mywallet.Repository.RevenueRepository;
import arekkasu.mywallet.Repository.RolesRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Admin service.
 */
@Service
public class AdminService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private RevenueRepository revenueRepository;


    /**
     * Users list list.
     *
     * @return the list
     */
//SECCION DE USUARIOS
    public List<Users> usersList(){
        return usersRepository.findAllByOrderByIdUsersAsc();
    }

    /**
     * Find user by id users users.
     *
     * @param id the id
     * @return the users
     */
//BUSCAR USUARIO POR ID
    public Users findUserByIdUsers(Long id){
        return usersRepository.findByIdUsers(id);
    }

    /**
     * User register users.
     *
     * @param registerUser the register user
     * @return the users
     */
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


    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
//COMPROBAR SI EXISTE
    public boolean existsByUsername(String username){
        return usersRepository.existsByUsername(username);
    }


    /**
     * Save user users.
     *
     * @param user the user
     * @return the users
     */
//Guardar usuario
    public Users saveUser(Users user){
        return usersRepository.save(user);
    }


    //ELIMINAR USUARIO

    /**
     * Delete user.
     *
     * @param id the id
     */
    @Transactional
    public void deleteUser(Long id) {
        Optional<Users> usuario = usersRepository.findById(id);
        if (usuario.isPresent()) {
            Users user = usuario.get();
            // Check if the user has the admin or user role
            boolean isAdminOrUser = user.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ROLE_ADMIN") || role.getRoleName().equals("ROLE_USER"));
            if (!isAdminOrUser) {
                // Remove all roles from the user
                user.getRoles().clear();
                // Save the user
                usersRepository.save(user);
            }
            // Now you can delete the user
            usersRepository.deleteById(id);
        } else {
            System.out.println("no EXiste o ya fue eliminado");
        }
    }




    //LISTADO DE GASTO DE TODOS

    /**
     * Find all expenses list.
     *
     * @return the list
     */
    public List<Expenses> findAllExpenses(){
        return expensesRepository.findAll();
    }


    //LISTADO DE GASTO POR NOMBRE DE USUARIO

    /**
     * Expenses by username list.
     *
     * @param id the id
     * @return the list
     */
    public List<Expenses> expensesByUsername(Long id){

        return expensesRepository.findByUsers_IdUsers(id);

    }

    /**
     * Find expense by id expenses.
     *
     * @param id the id
     * @return the expenses
     */
    public Expenses findExpenseById(Long id){
        return expensesRepository.findByIdExpenses(id);
    }

    /**
     * Save expense expenses.
     *
     * @param expenseDto the expense dto
     * @return the expenses
     */
    @Transactional
    public Expenses saveExpense(expenseDto expenseDto){
        Users users = usersRepository.findByUsername(expenseDto.getUsername());
        Expenses expenses = new Expenses(expenseDto.getExpenseHeader(),
                expenseDto.getExpenseDescription()
                ,expenseDto.getExpenseDate(), expenseDto.getExpenseAmount(), users);
        return expensesRepository.save(expenses);

    }

    /**
     * Save edit expense expenses.
     *
     * @param editExpense the edit expense
     * @return the expenses
     */
    @Transactional
    public Expenses saveEditExpense(editExpense editExpense){
        Users users = usersRepository.findByUsername(editExpense.getUsername());
        Expenses expenses = expensesRepository.findByIdExpenses(editExpense.getIdExpense());
        expenses.setExpenseHeader(editExpense.getexpenseHeader());
        expenses.setExpenseDescription(editExpense.getexpenseDescription());
        expenses.setExpenseDate(editExpense.getexpenseDate());
        expenses.setExpenseAmount(editExpense.getexpenseAmount());
        expenses.setUsers(users);
        return expensesRepository.save(expenses);
    }


    /**
     * Delete expense.
     *
     * @param id the id
     */
//ELIMINAR GASTO POR ID
    @Transactional
    public void deleteExpense(Long id){
        expensesRepository.deleteByIdExpenses(id);
    }


    /**
     * Find all revenues list.
     *
     * @return the list
     */
//LISTAD DE TODOS LOS INGRESOS
    public List<Revenue> findAllRevenues(){
        return revenueRepository.findAll();
    }


    /**
     * Find revenue by id revenue.
     *
     * @param id the id
     * @return the revenue
     */
//LISTADO DE INGRESOS POR ID de ingreso
    public Revenue findRevenueById(Long id){
        return revenueRepository.findByIdRevenue(id);
    }


    //Listado de ingresos por usuario

    /**
     * Revenue by username list.
     *
     * @param username the username
     * @return the list
     */
    public List<Revenue> revenueByUsername(String username){
        return revenueRepository.findByUsers_Username(username);
    }


    /**
     * Delete revenue.
     *
     * @param id the id
     */
//ELIMINAR INGRESO POR ID
    @Transactional
    public void deleteRevenue(Long id){
        Optional<Revenue> revenue = revenueRepository.findById(id);
        if (revenue.isPresent()) {
            revenueRepository.deleteById(id);
        } else {
            System.out.println("no EXiste el ingreso o ya fue eliminado");
        }
    }

    /**
     * Save revenue revenue.
     *
     * @param revenueDTO the revenue dto
     * @return the revenue
     */
    @Transactional
    public Revenue saveRevenue(revenueDto revenueDTO){
        Users users = usersRepository.findByUsername(revenueDTO.getUsername());
        Revenue revenue = new Revenue(revenueDTO.getRevenueHeader(),
                revenueDTO.getRevenueDescription()
                ,revenueDTO.getRevenueDate(), revenueDTO.getRevenueAmount(), users);
        return revenueRepository.save(revenue);

    }

    /**
     * Save edit revenue revenue.
     *
     * @param editRevenue the edit revenue
     * @return the revenue
     */
    @Transactional
    public Revenue saveEditRevenue(editRevenue editRevenue){
        Users users = usersRepository.findByUsername(editRevenue.getUsername());
        Revenue revenue = revenueRepository.findByIdRevenue(editRevenue.getIdRevenue());
        revenue.setRevenueHeader(editRevenue.getRevenueHeader());
        revenue.setRevenueDescription(editRevenue.getRevenueDescription());
        revenue.setRevenueDate(editRevenue.getRevenueDate());
        revenue.setRevenueAmount(editRevenue.getRevenueAmount());
        revenue.setUsers(users);
        return revenueRepository.save(revenue);
    }







}
