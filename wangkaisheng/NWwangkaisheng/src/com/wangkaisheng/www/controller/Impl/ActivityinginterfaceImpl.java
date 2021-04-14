package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Activityinginterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class ActivityinginterfaceImpl implements Activityinginterface {
    private final Service service = new ServiceImpl();
    @Override
    public AllActivity findMyActivitying(Organizer organizer) {
        return service.findMyActivitying(organizer);
    }

    @Override
    public AllActivity findActivitying(Activity activity) {
        return service.findActivitying(activity);
    }

    @Override
    public Activity getAllActivitying(AllActivity allActivity, Activity activity) {
        return service.getAllActivity(allActivity,activity);
    }
}
