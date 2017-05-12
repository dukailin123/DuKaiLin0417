package com.example.administrator.dukailin0417;

/**
 * Created by Administrator on 2017/4/17 0017.
 */

public class Bean {
    public String name;
    public Boolean ischend;



    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIschend() {
        return ischend;
    }

    public void setIschend(Boolean ischend) {
        this.ischend = ischend;
    }
    public Bean(String name, Boolean ischend) {
        this.name = name;
        this.ischend = ischend;
    }
}
