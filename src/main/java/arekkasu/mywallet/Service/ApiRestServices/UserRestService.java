package arekkasu.mywallet.Service.ApiRestServices;


import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Repository.ExpensesRepository;
import arekkasu.mywallet.Repository.RevenueRepository;
import arekkasu.mywallet.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRestService {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private RevenueRepository revenueRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    public List<Revenue> recentRevenue(String username){
        return revenueRepository.findTop10ByUsers_Username(username);
    }

    public List<Expenses> recentExpenses(String username){
        return expensesRepository.findTop10ByUsers_Username(username);
    }



}
