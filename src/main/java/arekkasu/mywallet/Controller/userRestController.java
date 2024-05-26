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

/**
 * The type User rest controller.
 */
@RestController
@RequestMapping("/userAPI")
public class userRestController {


    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRestService userRestService;


    /**
     * Recent revenue list.
     *
     * @return the list
     */
    @GetMapping("/recentRevenue")
    public List<Revenue> recentRevenue( ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRestService.recentRevenue(username);
    }

    /**
     * Recent expenses list.
     *
     * @return the list
     */
    @GetMapping("/recentExpenses")
    public List<Expenses> recentExpenses( ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRestService.recentExpenses(username);
    }










}

