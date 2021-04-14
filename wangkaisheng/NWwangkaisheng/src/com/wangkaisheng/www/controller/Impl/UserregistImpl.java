package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Userregist;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class UserregistImpl implements Userregist {
    private final Service service = new ServiceImpl();
    @Override
    public boolean regist(User user) {
        return service.regist(user);
    }
}
