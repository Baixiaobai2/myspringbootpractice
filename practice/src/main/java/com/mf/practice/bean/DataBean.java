package com.mf.practice.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor@NoArgsConstructor@TableName("data_bean")
public class DataBean {

    private String name;
//    private int confirmAdd;
    private int confirm;
    private int dead;
    private int heal;

}
