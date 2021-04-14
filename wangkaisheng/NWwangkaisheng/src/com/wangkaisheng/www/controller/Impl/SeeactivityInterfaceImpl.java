package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.SeeactivityInterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class SeeactivityInterfaceImpl implements SeeactivityInterface {
    private final Service service = new ServiceImpl();
    @Override
    public boolean attendActivity(User user, Activity activity) {
        return service.attendActivity(user,activity);
    }

    @Override
    public boolean cancelActivity(User user, Activity activity) {
        return service.cancelActivity(user,activity);
    }

    @Override
    public boolean isActivity(User user, Activity activity) {
        return service.isActivity(user,activity);
    }

    @Override
    public boolean cancelActivitying(Activity activity) {
        return service.cancelActivitying(activity);
    }

    @Override
    public boolean adoptActivitying(Activity activity) {
        return service.adoptActivitying(activity);
    }

}
