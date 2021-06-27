package com.mf.practice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mf.practice.bean.DataBean;

import java.util.List;

public interface DataService extends IService<DataBean> {

    List<DataBean> getList();

    List<DataBean> getDatat();

    List<DataBean> getDatad();

    List<DataBean> getListById(int id);



}
