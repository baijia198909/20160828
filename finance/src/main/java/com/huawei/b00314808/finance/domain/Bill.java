package com.huawei.b00314808.finance.domain;

import java.sql.Date;

public class Bill {
    public Long id;
    
    public String name;
    
    public Date date;
    
    public String item;
    
    public String price;
    
    public String remark;
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getItem() {
        return item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
