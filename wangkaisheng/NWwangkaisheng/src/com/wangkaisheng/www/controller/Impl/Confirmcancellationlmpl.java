package com.wangkaisheng.www.controller.Impl;


import com.wangkaisheng.www.controller.Confirmcancellation;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class Confirmcancellationlmpl implements Confirmcancellation {
    private final Service service = new ServiceImpl();

    @Override
    public boolean confirmcancellation(User user) {
        return service.cancelUser(user);
    }
}
