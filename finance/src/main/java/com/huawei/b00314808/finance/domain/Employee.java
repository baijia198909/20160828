package com.huawei.b00314808.finance.domain;
/**
 * 
 * @author zhangyu
 *
 */

public class Employee {

    
    public Long id;
    
    public String user;
    
    public String password;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return user;
    }

    public void setName(String user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
