package arekkasu.mywallet.Service;


import arekkasu.mywallet.Controller.DTO.RegisterUserDTO;
import arekkasu.mywallet.Controller.DTO.editExpense;
import arekkasu.mywallet.Controller.DTO.expenseDto;
import arekkasu.mywallet.Controller.DTO.usersDTO.userEditExpense;
import arekkasu.mywallet.Controller.DTO.usersDTO.userEditRevenue;
import arekkasu.mywallet.Controller.DTO.usersDTO.userExpenseDTO;
import arekkasu.mywallet.Controller.DTO.usersDTO.userRevenueDTO;
import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Model.Roles;
import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Repository.ExpensesRepository;
import arekkasu.mywallet.Repository.RevenueRepository;
import arekkasu.mywallet.Repository.RolesRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private ExpensesRepository expensesRepository;
    @Autowired
    private RevenueRepository revenueRepository;


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
        Users user = usersRepository.findByUsername(username.toLowerCase());

        if (user == null ){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(user.getUsername(), user.getPassword(), mapearAutoridadesRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Roles> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }






    //EXPENSES


    public Expenses findExpenseById(Long id){
        return expensesRepository.findByIdExpenses(id);
    }

    @Transactional
    public Expenses saveExpense(userExpenseDTO expenseDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByUsername(username);
        Expenses expenses = new Expenses(expenseDto.getExpenseHeader(), expenseDto.getExpenseDescription(),
                expenseDto.getExpenseDate(), expenseDto.getExpenseAmount(), user);
        System.out.println("ENTRO AL INSERT");
        return expensesRepository.save(expenses);
    }

    @Transactional
    public Expenses saveEditExpense(userEditExpense editExpense){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByUsername(username);
        Expenses expenses = expensesRepository.findByIdExpenses(editExpense.getIdExpense());
        expenses.setExpenseHeader(editExpense.getExpenseHeader());
        expenses.setExpenseDescription(editExpense.getExpenseDescription());
        expenses.setExpenseDate(editExpense.getExpenseDate());
        expenses.setExpenseAmount(editExpense.getExpenseAmount());
        expenses.setUsers(user);
        return expensesRepository.save(expenses);
    }




    //REVENUES


    public Revenue findRevenueById(Long id){
        return revenueRepository.findByIdRevenue(id);
    }

    @Transactional
    public Revenue saveRevenue(userRevenueDTO revenueDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByUsername(username);
        Revenue revenue = new Revenue(revenueDto.getRevenueHeader(), revenueDto.getRevenueDescription(),
                revenueDto.getRevenueDate(), revenueDto.getRevenueAmount(), user);
        System.out.println("ENTRO AL INSERT");
        return revenueRepository.save(revenue);
    }

    @Transactional
    public Revenue saveEditRevenue(userEditRevenue editRevenue){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findByUsername(username);
        Revenue revenue = revenueRepository.findByIdRevenue(editRevenue.getIdRevenue());
        revenue.setRevenueHeader(editRevenue.getRevenueHeader());
        revenue.setRevenueDescription(editRevenue.getRevenueDescription());
        revenue.setRevenueDate(editRevenue.getRevenueDate());
        revenue.setRevenueAmount(editRevenue.getRevenueAmount());
        revenue.setUsers(user);
        return revenueRepository.save(revenue);
    }
}
