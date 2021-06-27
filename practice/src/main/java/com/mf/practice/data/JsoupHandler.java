package com.mf.practice.data;

import com.google.gson.Gson;
import com.mf.practice.bean.DataBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Map;
//解析页面
public class JsoupHandler {

    public static ArrayList<DataBean> getData() {

        ArrayList<DataBean> result = new ArrayList<>();

        try {
            // 直接传递url获取返回结果
            Document doc1 = Jsoup.connect("https://ncov.dxy.cn/ncovh5/view/pneumonia?scene=2&from=singlemessage&isappinstalled=0").get();
            Element element = doc1.getElementById("getAreaStat");
            // 取到标签里的内容
            String data = element.data();

            // 通过截取 中括号的方式  拿到json数据
            String subData = data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);

            Gson gson = new Gson();
            ArrayList list = gson.fromJson(subData, ArrayList.class);

            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String name = (String) map.get("provinceName");
                double confirm = (Double) map.get("confirmedCount");
                double dead = (Double) map.get("deadCount");
                double heal = (Double) map.get("curedCount");

                DataBean dataBean = new DataBean(name, (int) confirm, (int) dead, (int) heal);
                result.add(dataBean);
            }

        } catch (Exception e) {

        }

        return result;
    }

}
