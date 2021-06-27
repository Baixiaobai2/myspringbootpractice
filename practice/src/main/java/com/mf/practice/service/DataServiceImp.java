package com.mf.practice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.practice.bean.DataBean;
import com.mf.practice.data.DataHandler;
import com.mf.practice.data.JsoupHandler;
import com.mf.practice.mapper.DataMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImp extends ServiceImpl<DataMapper,DataBean>
        implements DataService{
    @Override
    public List<DataBean> getList() {
        return DataHandler.getList();
    }

    public List<DataBean> getDatat(){return DataHandler.getData(); }

    public List<DataBean> getDatad(){return JsoupHandler.getData(); }

    public List<DataBean> getListById(int id){
        if (1==id){
            return DataHandler.getData();//t
        }else {
            return JsoupHandler.getData();//d
        }
    }

}
