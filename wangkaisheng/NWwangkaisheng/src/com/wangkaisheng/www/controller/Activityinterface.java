package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;

public interface Activityinterface {
    AllActivity findAllActivity();

    AllActivity findActivity(Activity activity);

    Activity getAllActivity(AllActivity allActivity,Activity activity);
}
