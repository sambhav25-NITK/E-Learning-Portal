package com.example.techademy.Controller;

import com.example.techademy.Database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/feedbackList")
    public String feedbackList(Model model)
    {
        List<Feedback> feedback=feedbackRepository.findAll();
        model.addAttribute("feedback",feedback);
        return "listAllFeedback";
    }

    @GetMapping("/addFeedback")
    public String addFeedback(Model model)
    {
        model.addAttribute("feedback",new Feedback());
        return "addFeedback";
    }

    @PostMapping("/addFeedback")
    public String addFeedback(@ModelAttribute("feedback") Feedback f)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String email;
            if (principal instanceof UserDetails) {
                email = ((UserDetails) principal).getUsername();
            } else {
                email = principal.toString();
            }
            User u = userRepository.findByEmail(email);
            System.out.println(u);
            f.setUserId(u.getUserId());
            feedbackRepository.save(f);


        return "userView";
    }
}
