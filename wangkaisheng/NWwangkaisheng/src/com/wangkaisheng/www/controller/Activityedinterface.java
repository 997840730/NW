package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;

public interface Activityedinterface {
    AllActivity findMyActivity(Organizer organizer);

    AllActivity findActivity(Activity activity);

    Activity getAllActivity(AllActivity allActivity, Activity activity);
}
