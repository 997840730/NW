package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.User;

public interface SeeactivityInterface {
    boolean attendActivity(User user, Activity activity);

    boolean cancelActivity(User user, Activity activity);

    boolean isActivity(User user, Activity activity);

    boolean cancelActivitying(Activity activity);

    boolean adoptActivitying(Activity activity);

}
