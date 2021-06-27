package com.mf.practice.controller;

import com.google.gson.Gson;
import com.mf.practice.bean.DataBean;
import com.mf.practice.bean.MapBean;
import com.mf.practice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

    @Autowired
    private DataService dataService;

    @GetMapping("/map")
    public String show(Model model){
        List<DataBean> list = dataService.list();

        List<MapBean> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            DataBean dataBean = list.get(i);

            MapBean mapBean = new MapBean(dataBean.getName(),dataBean.getConfirm());
            result.add(mapBean);
        }

        model.addAttribute("mapData",new Gson().toJson(result));
        return "map";
    }

}
