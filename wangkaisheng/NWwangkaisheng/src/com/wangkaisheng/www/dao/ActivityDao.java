package com.wangkaisheng.www.dao;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.User;

public interface ActivityDao {
    AllActivity findAllActivity();

    AllActivity findActivity(Activity activity);

    boolean attendActivity(User user, Activity activity);

    boolean isAttend(User user, Activity activity);

    boolean canaelActivity(User user, Activity activity);

    boolean isActivity(User user, Activity activity);

    boolean addactivity(Activity activity);

    AllActivity findMyActivity(Organizer organizer);

    AllActivity findActivityed(Activity activity);

    boolean overlActivity(Activity activity);

    AllActivity findMyActivitying(Organizer organizer);

    AllActivity findActivitying(Activity activity);

    boolean canaelActivitying(Activity activity);

    boolean adoptUser(User user1, Activity activity);

    boolean adoptactivity(Activity activity);

    boolean findActivityBy(Activity activity);
}
