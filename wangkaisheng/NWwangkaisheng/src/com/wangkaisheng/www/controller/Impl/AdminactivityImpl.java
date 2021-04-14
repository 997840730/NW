package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Adminactivity;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class AdminactivityImpl implements Adminactivity {
    private final Service service = new ServiceImpl();
    @Override
    public AllActivity findAllActivity() {
        return service.findAllActivitying();
    }

    @Override
    public AllActivity findActivity(Activity activity) {
        return service.findActivitying(activity);
    }

    @Override
    public Activity getAllActivity(AllActivity allActivity, Activity activity) {
        return service.getAllActivity(allActivity,activity);
    }
}
