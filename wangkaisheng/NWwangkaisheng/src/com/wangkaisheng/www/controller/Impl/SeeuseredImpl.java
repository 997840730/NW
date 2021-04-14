package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Seeusered;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class SeeuseredImpl implements Seeusered {
    private final Service service = new ServiceImpl();
    @Override
    public AllUser findUser(Activity activity) {
        return service.findUser(activity);
    }

    @Override
    public boolean overActivity(AllUser allUser,Activity activity) {
        int temp;
        for (User user: allUser.getUserList()){
            temp=user.getTime();
            user.setTime((temp+2));
            System.out.println(user.getTime());
            service.updateUser(user);
        }
        return service.overActivity(activity);
    }
}
