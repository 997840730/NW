package com.wangkaisheng.www.controller.Impl;


import com.wangkaisheng.www.controller.Informationinterface;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class InformationinterfaceImpl implements Informationinterface {
    private final Service service = new ServiceImpl();

    @Override
    public boolean modifyUser(User user) {
        return service.updateUser(user);
    }
}
