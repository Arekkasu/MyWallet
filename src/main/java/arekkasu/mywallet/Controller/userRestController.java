package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Model.Expenses;
import arekkasu.mywallet.Model.Revenue;
import arekkasu.mywallet.Service.ApiRestServices.UserRestService;
import arekkasu.mywallet.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userAPI")
public class userRestController {


    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRestService userRestService;



    @GetMapping("/recentRevenue")
    public List<Revenue> recentRevenue( ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRestService.recentRevenue(username);
    }

    @GetMapping("/recentExpenses")
    public List<Expenses> recentExpenses( ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRestService.recentExpenses(username);
    }










}

