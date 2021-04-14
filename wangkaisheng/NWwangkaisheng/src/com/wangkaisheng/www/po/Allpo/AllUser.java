package com.wangkaisheng.www.po.Allpo;

import com.wangkaisheng.www.po.Notice;
import com.wangkaisheng.www.po.User;

import java.util.List;

public class AllUser {
    private List<User> userList;

    public AllUser() {
    }

    public AllUser(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
