package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.User;

/**
 * @author Administrator
 */
public interface Seeusering {
    AllUser findUser(Activity activity);

    boolean adoptUser(User user,Activity activity);
}
