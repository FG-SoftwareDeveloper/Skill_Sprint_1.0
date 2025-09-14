package com.railway.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LandingController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "landing";
    }

    @GetMapping("/features")
    public String features() {
        return "marketing/features"; // assumes you have features.html
    }

    @GetMapping("/pricing")
    public String pricing() {
        return "marketing/pricing"; // assumes you have pricing.html
    }

    @GetMapping("/demo")
    public String demo() {
        return "marketing/demo"; // assumes you have demo.html
    }

}
