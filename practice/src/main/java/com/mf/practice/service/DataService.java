package com.mf.practice.service;

import com.mf.practice.bean.DataBean;

import java.util.List;

public interface DataService {

    List<DataBean> getList();

    List<DataBean> getDatat();

    List<DataBean> getDatad();

    List<DataBean> getListById(int id);

    List<DataBean> getListByDB();

}
