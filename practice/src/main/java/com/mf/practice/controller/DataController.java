package com.mf.practice.controller;

import com.mf.practice.bean.DataBean;
import com.mf.practice.service.DataService;
import com.mf.practice.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//        List<DataBean> dataBeanList= dataService.getList();
//        List<DataBean> dataBeanList= dataService.getDatat();
        List<DataBean> dataBeanList=dataService.getDatad();
        modelAndView.addObject("dataBeanList",dataBeanList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @GetMapping("/getListById/{id}")
    public ModelAndView getListById(@PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView();
        List<DataBean> dataBeanList=dataService.getListById(id);
        modelAndView.addObject("dataBeanList",dataBeanList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

//    @GetMapping("/getListByDB")
//    public ModelAndView getListByDB(){
//        ModelAndView modelAndView=new ModelAndView();
//        List<DataBean> dataBeanList=dataService.
//        modelAndView.addObject("dataBeanList",dataBeanList);
//        modelAndView.setViewName("list");
//        return modelAndView;
//    }

}
