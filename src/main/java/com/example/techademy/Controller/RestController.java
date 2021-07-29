package com.example.techademy.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/")
    public String test()
    {
        return "sambhav khandelwal";
    }
}
