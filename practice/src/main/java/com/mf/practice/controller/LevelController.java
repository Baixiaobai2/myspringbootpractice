package com.mf.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LevelController {

    @GetMapping("/")
    public String index() {
        return "welcome";
    }//输入localhost:8090访问welcome页

    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return "level1/" + path;
    }


    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return "level2/" + path;
    }

    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return "level3/" + path;
    }

}
