package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Activityedinterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class ActivityedinterfaceImpl implements Activityedinterface {
    private final Service service = new ServiceImpl();
    @Override
    public AllActivity findMyActivity(Organizer organizer) {
        return service.findMyActivity(organizer);
    }

    @Override
    public AllActivity findActivity(Activity activity) {
        return service.findActivityed(activity);
    }

    @Override
    public Activity getAllActivity(AllActivity allActivity, Activity activity) {
        return service.getAllActivity(allActivity,activity);
    }
}
