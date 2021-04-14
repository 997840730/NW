package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Userlogin;
import com.wangkaisheng.www.dao.Impl.UserDaoImpl;
import com.wangkaisheng.www.dao.UserDao;
import com.wangkaisheng.www.po.User;

public class UserloginImpl implements Userlogin {
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public boolean isUser(User user) {
        return userDao.isUser(user);
    }
}
