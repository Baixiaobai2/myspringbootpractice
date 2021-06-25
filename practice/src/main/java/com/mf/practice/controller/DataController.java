package com.mf.practice.controller;

import com.mf.practice.bean.DataBean;
import com.mf.practice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class DataController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @Autowired
    private DataService dataService;

    @GetMapping("/getList")
    public ModelAndView getList(){
        ModelAndView modelAndView=new ModelAndView();
        List<DataBean> dataBeanList= dataService.getList();
        modelAndView.addObject("dataBeanList",dataBeanList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
