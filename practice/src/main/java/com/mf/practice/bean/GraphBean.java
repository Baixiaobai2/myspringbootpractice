package com.mf.practice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphBean {

    private String date;
    // 确诊人数
    private int confirm;
    // 疑似人数
    private int suspect;
}
