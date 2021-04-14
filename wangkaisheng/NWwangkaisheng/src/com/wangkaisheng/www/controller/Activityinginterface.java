package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;

public interface Activityinginterface {
    AllActivity findMyActivitying(Organizer organizer);

    AllActivity findActivitying(Activity activity);

    Activity getAllActivitying(AllActivity allActivity, Activity activity);
}
