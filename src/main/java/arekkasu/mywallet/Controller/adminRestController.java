package arekkasu.mywallet.Controller;


import arekkasu.mywallet.Model.Users;
import arekkasu.mywallet.Service.ApiRestServices.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/adminAPI")
public class adminRestController {


    @Autowired
    private AdminService adminService;

    @GetMapping("/usersList")
    public List<Users> usersList(HttpServletRequest request){
            return adminService.usersList();
    }



}
