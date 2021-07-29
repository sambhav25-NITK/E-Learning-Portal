package com.example.techademy.Controller;

import com.example.techademy.Admin.AdminLoginAttribute;
import com.example.techademy.Database.User;
import com.example.techademy.Database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/admin")
    public String admin(Model model)
    {
        model.addAttribute("admin",new AdminLoginAttribute());
        return "AdminLogin";
    }
    @PostMapping("/admin")
    public String admin(Model model, @ModelAttribute("admin") AdminLoginAttribute adminCredentials)
    {
       User user=userRepository.findByEmail(adminCredentials.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean check=passwordEncoder.matches(adminCredentials.getPassword(),user.getPassword());
        boolean b=user.getRole().equals("admin");


        if(user!=null && check && b)
            return "AdminView";
        else
            return "AdminLogin";
    }
    @GetMapping("/adminView")
    public String adminView()
    {
        return "adminView";
    }
}
