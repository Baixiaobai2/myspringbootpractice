package com.mf.practice.service;

import com.mf.practice.bean.DataBean;
import com.mf.practice.data.DataHandler;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImp implements DataService{
    @Override
    public List<DataBean> getList() {
        return DataHandler.getList();
    }
}
