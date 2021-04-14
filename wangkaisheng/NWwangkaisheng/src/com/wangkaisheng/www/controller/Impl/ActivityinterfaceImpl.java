package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Activityinterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class ActivityinterfaceImpl implements Activityinterface {
    private final Service service = new ServiceImpl();
    @Override
    public AllActivity findAllActivity() {
        return service.findAllActivity();
    }

    @Override
    public AllActivity findActivity(Activity activity) {
        return service.findActivity(activity);
    }

    @Override
    public Activity getAllActivity(AllActivity allActivity,Activity activity) {
        return service.getAllActivity(allActivity,activity);
    }
}
