package com.example.techademy.Controller;

import com.example.techademy.Database.Course;
import com.example.techademy.Database.CourseRepository;
import com.example.techademy.Database.User;
import com.example.techademy.Database.UserRepository;
import com.example.techademy.enroll.Enroll;
import com.example.techademy.enroll.EnrollBean;
import com.example.techademy.enroll.EnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    EnrollRepository enrollRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("courseList")
    public String courseList(Model model)
    {
        List<Course> course=courseRepository.findAll();
        model.addAttribute("course",course);
        return "listAllCourse";

    }
    @GetMapping("/addCourse")
    public String addCourse(Model model)
    {
        model.addAttribute("course",new Course());
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(@ModelAttribute("course") Course c)
    {
        courseRepository.save(c);
        return "AdminView";
    }
    @GetMapping("/enroll")
    public String enroll(Model model)
    {
        List<Course> courseList=courseRepository.findAll();
        model.addAttribute("courseList",courseList);
        model.addAttribute("enrollBean",new EnrollBean());
        return "enroll";
    }
    @PostMapping("/enroll")
    public String enroll(@ModelAttribute("enrollBean") EnrollBean bean )
    {


       Course c=courseRepository.findByCourseId(Long.parseLong(bean.getEnrolledCourseName()));


        Enroll e=new Enroll();
        e.setEnrolledCourseId(c.getCourseId());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        User u = userRepository.findByEmail(email);
        e.setEnrolledUserId(u.getUserId());
        enrollRepository.save(e);
        return "userView";
    }
    @GetMapping("/myCourses")
    public String myCourses(Model model)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        User u = userRepository.findByEmail(email);
        List<Enroll> enrolledUser=enrollRepository.findByEnrolledUserId(u.getUserId());

        List<Course> enrolledCourse=new ArrayList<>();
        for(int i=0;i<enrolledUser.size();i++)
        {
            enrolledCourse.add(courseRepository.findByCourseId(enrolledUser.get(i).getEnrolledCourseId()));
        }
        model.addAttribute("enrolledCourse",enrolledCourse);
        return "myCourses";
    }
}
