package com.example.techademy.Controller;

import com.example.techademy.Database.User;
import com.example.techademy.Database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/dashboard")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/signup")
    public String sign(Model model)
    {
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/process")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRegDate(LocalDate.now());
        user.setRole("user");
        userRepository.save(user);

        return "register_success";
    }
    @GetMapping("/userList")
    public String userList( Model model)
    {
        List<User> userList=userRepository.findByRole("user");
        model.addAttribute("user",userList);

        return "listAllUser";
    }

    @GetMapping("/userView")
    public String userView()
    {
        return "userView";
    }
}
