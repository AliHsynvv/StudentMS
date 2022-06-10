package com.company;

import com.company.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MyController {
    @GetMapping("")
    public String ShowMainMenu() {
        return "index";
    }
}
