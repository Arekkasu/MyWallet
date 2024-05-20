package arekkasu.mywallet.Service.ApiRestServices;


import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Repository.ExpensesRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    public List<Users> usersList(){
        return usersRepository.findAll();
    }



}
