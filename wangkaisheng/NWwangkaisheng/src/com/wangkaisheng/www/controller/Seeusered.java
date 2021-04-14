package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;

public interface Seeusered {
    AllUser findUser(Activity activity);

    boolean overActivity(AllUser allUser,Activity activity);
}
